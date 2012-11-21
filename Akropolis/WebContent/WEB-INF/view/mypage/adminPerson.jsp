<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>참여자관리</title>
<link href="/Akropolis/css/adminperson.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<form>
			<fieldset>
				<legend>참여자관리</legend>
				<div id="join">
					<h4>참여신청</h4>
					<div class="PS_li">
						<ul>
							<li><a href="#">김민아</a> <a href="#">신정미</a> <a href="#">이영학</a>
								<a href="#">박주영</a> <a href="#">김명란</a> <a href="#">문재인</a> <a
								href="#">페북인</a> <a href="#">난누구</a></li>
						</ul>
					</div>
					<div class="PS_inform">
						<div class="inform">
							<img src="/Akropolis/img/profile.png" title="사진" alt="이미지로드실패">
							<p>정보들...</p>
						</div>
						<div class="decision">
							<button class="btn" onclick="location.href='#'">OK</button>
							<button class="btn" onclick="location.href='#'">Sorry</button>
						</div>
					</div>
					<hr />
				</div>

				<div id="exit">
					<h4>퇴장신청</h4>
					<div class="PS_li">
						<ul>
							<li><a href="#">전두환</a> <a href="#">박정희</a> <a href="#">노무현</a>
								<a href="#">김영삼</a></li>
						</ul>
					</div>
					<div class="PS_inform">
						<div class="inform">
							<img src="/Akropolis/img/profile.png" title="사진" alt="이미지로드실패">
							<p>정보들...</p>
						</div>
						<div class="decision">
							<button class="btn" onclick="location.href='#'">OK</button>
							<button class="btn" onclick="location.href='#'">Sorry</button>
						</div>
					</div>
					<hr />
				</div>
				<div id="user">
					<h4>참여자</h4>
					<div class="PS_li">
						<ul>
							<li><a href="#">송인석</a> <a href="#">최성운</a> <a href="#">이명박</a>
								<a href="#">박근혜</a> <a href="#">안철수</a> <a href="#">최환종</a> <a
								href="#">최요종</a> <a href="#">한명호</a></li>
						</ul>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>