<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Akropolis </title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="/Akropolis/css/profile.css" rel="stylesheet" type="text/css"> 
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div id="profile">
			<div id="left">
				<img src="/Akropolis/img/profile.png" alt="profile photo"><br>
				<span>참여한 토론</span> 52<br>
				<span>내가 쓴 글</span> 162 <br>
			</div>
			<div id="right">
				<button class="btn pull-right" onclick="location.href='#'"> 수정</button>
				<h1>홍길동</h1>
				<span>학력</span> 명지대학교 재학<br>
				<span>관심사</span> 정치, 과학, 문화 <br>
				<span>하고 싶은 말</span> <br> 
				아재밌다! 토론 ^^ <br>
			</div>
			<div id="bottom">
				<span>명예 지수 </span> <i class="icon-thumbs-up"></i>
				<div class="progress progress-success progress-striped">
  					<div class="bar" style="width: 60%;"></div>
				</div>
				<span>불명예 지수 </span><i class="icon-thumbs-down"></i>
				<div class="progress progress-warning progress-striped">
  					<div class="bar" style="width: 20%;"></div>
				</div>
				<span>Follower</span>
				<button class="btn" onclick="location.href='#'"><i class=" icon-plus"></i></button>
				<button class="btn" onclick="location.href='#'"><i class=" icon-minus"></i></button><br>
			</div>
		</div>
	</div>
</body>
</html>

