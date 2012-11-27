package bean;

import hello.annotation.ParamMapping;



public class FaceBook {
	private String code;
	private String errorReason;
	private String error;
	private String errorDescription;
	private String state;
	private String accessToken;
	private String expires;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorReason() {
		return errorReason;
	}
	@ParamMapping("error_reason")
	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	@ParamMapping("error_description")
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAccessToken() {
		return accessToken;
	}
	@ParamMapping("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	
}
