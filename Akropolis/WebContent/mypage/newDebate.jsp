<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new debate</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="/Akropolis/css/newdebate.css" rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>

<body>
	<div id = "contents">
		<form>
		<fieldset>
		<legend>토론열기</legend>
		<label class="name">주제 :</label>
		<input type="text" name="subject">
		<p>
		<label class="name">태그 :</label>
		<input type="text" name="subject" >
		<button class="btn" onclick="location.href='#'">태그추가</button><p>
		
		<hr>
		<label class="name">소주제 :</label>
		<div id="sub_subject">
	<table>
	<tr>
	<!-- 첫셀은 order세줌  -->
		<th>1</th>
		<td> Some Text </td>
		<td>
		<button class="btn" onclick="location.href='#'">
			<img src="/Akropolis/img/penIcon.png" alt="편집">
		</button>
		</td>
	</tr>
	<tr>
	<!-- 첫셀은 order세줌  -->
		<th>2</th>
		<td> Some Text22 </td>
		<td>
		<button class="btn" onclick="location.href='#'">
			<img src="/Akropolis/img/penIcon.png" alt="편집">
		</button>
		</td>
	</tr>
		<tr>
	<!-- 첫셀은 order세줌  -->
		<th>3</th>
		<td colspan="2"><input type='text' size='15' class='sub'>
		<button class="btn" onclick="location.href='#'">저장</button></td>
	</tr>
	</table>
	<hr>
	
</div>
<pre>	Open :			Close :					
											OK
			아직 하는중입니다...</pre>
		<label class="name">참여자초대 :
		<input type="checkbox"> Yes </label>
		<div id="regist">
			<a href="#"><button type="submit" class="btn">등록</button></a>
		</div>
		</fieldset>
		</form>
		</div>
</body>
</html>