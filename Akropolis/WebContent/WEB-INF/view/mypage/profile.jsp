<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="page" content="profile">
	<link href="/Akropolis/css/profile.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		$(function() {
			
			$(".concern1").attr("disabled",true);
			$(".concern2").hide();
			$("#saveBtn").hide();
			$("#left>form>textarea").attr("disabled",true);
			
			$("#modifyBtn").click(function() {
				$(".concern1").hide();
				$(".concern2").show();
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
		${modle.user.interestList.size}
			<div id="left">
				<form method="POST" action="profile.ap">
					<input type="submit" class="btn" id="saveBtn" value="저장">
					<input type="button" class="btn" id="modifyBtn" value="수정">
					<h1>${model.user.name}</h1>
					<p><span>( ${model.user.email} )</span></p>
					<span>학력</span> ${model.user.education} <br/> 
					<span>관심사</span>
					<c:forEach var="interest" items="${model.user.interestList}">
						<input type="text" class="concern1 span3" value="${interest.interest}">
					</c:forEach>
					<select name="interest1" class="concern2 span3">
						<c:forEach var="interest" items="${model.interestList}">
							<option>
								${interest.interest}
							</option>
						</c:forEach>
					</select>
					<select name="interest2" class="concern2 span3">
						<c:forEach var="interest" items="${model.interestList}">
							<option>
								${interest.interest}
							</option>
						</c:forEach>
					</select>
					<select name="interest3" class="concern2 span3">
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
				<h5>프로필사진</h5>
				<img src="${model.user.photo}" class="img-polaroid" width="135" height="135" alt="profile photo"  >
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
				<div id="Follower" >
					<span>Follower</span>
					<div id="information">
						<span class="alert alert-info span6 pull-right">
							<i class="icon-bullhorn"></i> ${model.msg}
						</span>
						<form method="POST" action="addFollower.ap">
							<div class="input-prepend">
								<span class="add-on" >@</span> 
								<input type="text"  name="followerEmail" placeholder="Input e-mail">
								<input type="submit" class="btn" id="insert" value="추가">
							</div>
						</form>
					</div>
					<c:forEach var="follower" items="${model.followerList}">
						<div class="miniPorofile">
							<div class=miniPhoto>
								<img src="${follower.photo}" alt="follower photo">
							</div>
							<div class=inform>
								${follower.name}<br/>
								( ${follower.email} )
							</div>
							<div class="form-action">
								<a href="/Akropolis/mypage/profile.ap?follower=${follower.email}" class="btn pull-right">
									<i class="icon-remove"></i>
								</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>





