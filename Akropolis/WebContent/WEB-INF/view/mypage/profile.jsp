<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// test value -> DB에서 값 가져오기
	String photo="/Akropolis/img/profile.png";
	int debateNum=52;
	int opinionNum=150;
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="page" content="profile"/>
	<link href="/Akropolis/css/profile.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		$(function() {
			$("#left").find(".concern").eq(0).val("${model.user.interestList.get(0).interest}");
			$("#left").find(".concern").eq(1).val("${model.user.interestList.get(1).interest}");
			$("#left").find(".concern").eq(2).val("${model.user.interestList.get(2).interest}");
			$("#saveBtn").hide();
			$("#left>form>textarea").attr("disabled",true);
			$(".concern").attr("disabled",true);
			
			$("#modifyBtn").click(function() {
				$("#modifyBtn").hide();
				$("#saveBtn").show();
				$("#left>form>textarea").attr("disabled",false);
				$(".concern").attr("disabled",false);
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<div id="profile">
			<div id="left">
				<form method="POST">
					<input type="submit" class="btn" id="saveBtn" value="저장">
					<input type="button" class="btn" id="modifyBtn" value="수정">
					<h1>${model.user.name}</h1>
					<span>( ${model.user.email} )</span><br /> 
					<span>학력</span> ${model.user.education} <br /> 
					<span>관심사</span>
					<select name="interest1" class="concern span3">
						<c:forEach var="interest" items="${model.interestList}">
							<option>
								${interest.interest}
							</option>
						</c:forEach>
					</select> ,
					<select name="interest2" class="concern span3">
						<c:forEach var="interest" items="${model.interestList}">
							<option>
								${interest.interest}
							</option>
						</c:forEach>
					</select> ,
					<select name="interest3" class="concern span3">
						<c:forEach var="interest" items="${model.interestList}">
							<option>
								${interest.interest}
							</option>
						</c:forEach>
					</select> <br /> 
					<span>하고 싶은 말</span> <br/>
					<textarea rows="2" name="say">${model.user.say}</textarea>
				</form>
			</div>

			<div id="right">
				<img src=<%=photo%> alt="profile photo"><br /><br /> 
				<span>참여한 토론</span> <%=debateNum%><br /> 
				<span>내가 쓴 글</span> <%=opinionNum%><br />
			</div>

			<div id="bottom">
				<span>명예 지수 </span> <i class="icon-thumbs-up"></i>${model.user.honor}
				<div class="progress progress-success progress-striped"> 
					<div class="bar" style="width: ${model.user.honor}%;"></div>
				</div>
				<span>불명예 지수 </span><i class="icon-thumbs-down"></i>${model.user.dishonor}
				<div class="progress progress-warning progress-striped">
					<div class="bar" style="width: ${model.user.dishonor}%;"></div>
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





