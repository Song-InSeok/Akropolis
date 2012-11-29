package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bean.FaceBook;
import bean.User;

import com.mysql.jdbc.StringUtils;

public class FaceBookAuth {
	public List<String> getAuth(FaceBook fb,String appID,String callback,String appSecret){
		URL url = null;
		BufferedReader br = null;
		HttpURLConnection conn = null;
		if(!StringUtils.isNullOrEmpty(fb.getCode())){
			try {
				url = new URL("https://graph.facebook.com/oauth/access_token?client_id="+
						appID+"&redirect_uri="+
						callback+"&client_secret="+
						appSecret+
						"&code="+fb.getCode());
				conn = (HttpURLConnection)url.openConnection();
				if (conn != null) {
					conn.setConnectTimeout(10000);
					conn.setUseCaches(false);
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						br = new BufferedReader(
								new InputStreamReader(conn.getInputStream()));
						for (;;) {
							String line = br.readLine();
							if (line == null) break;
							List<String> list = new ArrayList<String>();
							list.add(line.substring(line.indexOf("=")+1, line.indexOf("&")));
							list.add(line.substring(line.lastIndexOf("=")+1));
							return list;
						}
					}
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(br != null) try { br.close();} catch (IOException e) {e.printStackTrace();}
				if(conn != null) conn.disconnect();
			}
		}
		return null;
	}
	
	public JSONObject getInfo(String accessToken){
		URL url = null;
		BufferedReader br = null;
		HttpURLConnection conn = null;
		JSONParser parser = new JSONParser();
		try {
			url = new URL("https://graph.facebook.com/me?access_token="+accessToken);
			System.out.println("https://graph.facebook.com/me?access_token="+accessToken); //임시 log
			conn = (HttpURLConnection) url.openConnection();
			if(conn != null){
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
					br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					for (;;) {
						String line = br.readLine();
						if (line == null) break;
						return (JSONObject)parser.parse(line);
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(br != null) try { br.close();} catch (IOException e) {e.printStackTrace();}
			if(conn != null) conn.disconnect();
		}
		return null;
	}
	
	public User JSONUserMapper(JSONObject obj){
		User user = new User();
		user.setName((String)obj.get("name"));
		user.setEmail((String)obj.get("email"));
		user.setHonor(0);
		user.setDishonor(0);
		user.setPhoto("http://graph.facebook.com/"+(String)obj.get("username")+"/picture");
		user.setSay("");
		JSONArray array = (JSONArray)obj.get("education");
		JSONObject obj2 = (JSONObject)array.get(array.size()-1);
		user.setEducation((String)((JSONObject)obj2.get("school")).get("name"));
		return user;
	}
}
