<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/Akropolis/css/profile.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function() {
	$("#modifyBtn").click(function() {
		window.alert("Test");
	});
});
</script>
</head>
<body>
	<div class="container">
		<div id="profile">
			<div id="left">
				<input type="button" class="btn" id="modifyBtn" value="수정">
				<h1>홍길동</h1>
				<span>학력</span> 명지대학교 재학<br /> <span>관심사</span> 정치, 과학, 문화 <br />
				<span>하고 싶은 말</span> <br />
				<textarea rows="4"></textarea>
			</div>

			<div id="right">
				<img src="/Akropolis/img/profile.png" alt="profile photo"><br />
				<br /> <span>참여한 토론</span> 52<br /> <span>내가 쓴 글</span> 162 <br />
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
				<div id="Follower">
					<br /> <span>Follower</span>
					<div class="input-prepend">
						<span class="add-on">@</span> <input class="span5"
							id="prependedInput" type="text" placeholder="Username">

						<button class="btn" onclick="location.href='#'">
							<i class=" icon-plus"></i>
						</button>
						<button class="btn" onclick="location.href='#'">
							<i class=" icon-minus"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>





