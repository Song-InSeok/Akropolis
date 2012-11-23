<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// test value -> DB에서 값 가져오기
	String name="홍길동";
	String school="명지대학교 재학";
	String[] concerns={"정치","과학","문화"};
	String say="아 재밌다 토론 ~ ^^";
	String photo="/Akropolis/img/profile.png";
	int debateNum=52;
	int opinionNum=150;
	int honor=75;
	int dishonor=12;
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="page" content="profile"/>
	<link href="/Akropolis/css/profile.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		$(function() {
			$("#saveBtn").hide();
			$("#left>form>textarea").attr("disabled",true);
			$(".concern").attr("disabled",true);
			
			$("#modifyBtn").click(function() {
				$("#modifyBtn").hide();
				$("#saveBtn").show();
				$("#left>form>textarea").attr("disabled",false);
				$(".concern").attr("disabled",false);
			});
			$("#saveBtn").click(function() {
				$("#saveBtn").hide();
				$("#modifyBtn").show();
				$("#left>form>textarea").attr("disabled",true);
				$(".concern").attr("disabled",true);
			});
		});
	</script>
</head>
<body>
 <%
  if (request.getMethod() == "POST") {
	  // DB 수정?
	 //concerns[0]=request.getParameter("concern");
	// say=request.getParameter("say");
  }
 %>
	<div class="container">
		<div id="profile">
			<div id="left">
				<form method="POST">
					<input type="submit" class="btn" id="saveBtn" value="저장">
					<input type="button" class="btn" id="modifyBtn" value="수정">
					<h1><%=name%></h1>
					<span>학력</span> <%=school%><br /> 
					<span>관심사</span>
					<input type="text" name="concern" class="concern" value=<%=concerns[0]%>> ,
					<input type="text" name="concern" class="concern" value=<%=concerns[1]%>> ,
					<input type="text" name="concern" class="concern" value=<%=concerns[2]%>> <br /> 
					<span>하고 싶은 말</span> <br/>
					<textarea rows="3" name="say"><%=say%></textarea>
				</form>
			</div>

			<div id="right">
				<img src=<%=photo%> alt="profile photo"><br /><br /> 
				<span>참여한 토론</span> <%=debateNum%><br /> 
				<span>내가 쓴 글</span> <%=opinionNum%><br />
			</div>

			<div id="bottom">
				<span>명예 지수 </span> <i class="icon-thumbs-up"></i> <%=honor%>
				<div class="progress progress-success progress-striped"> 
					<div class="bar" style="width: <%=honor%>%;"></div>
				</div>
				<span>불명예 지수 </span><i class="icon-thumbs-down"></i> <%=dishonor%>
				<div class="progress progress-warning progress-striped">
					<div class="bar" style="width: <%=dishonor%>%;"></div>
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





