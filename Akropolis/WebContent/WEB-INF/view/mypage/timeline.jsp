<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="page" content="timeline"/>
	<link href="/Akropolis/css/timeline.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<div class="container">
		<div id="timeline">
			<div id="top">
				<img src="${model.user.photo}"  class="img-polaroid" width="80" height="80" alt="profile photo"  >
				<h1>TimeLine</h1>
				<p>
					<span class="lead">${model.user.name}</span>
					<span>( ${model.user.email} )</span>
				</p>		
			</div>
			<div id="bottom">
				<ul>
					<c:forEach var="item" items="${model.timeline}">
						<li>				
							<p class="lead" id="topic">
								<a href="/Akropolis/debate.ap?mt=${item.mt_id}">${item.mt_title}</a>
							</p>
							<!-- request 'Y' 참여중 'D' 요청중 "I" 는 초대중 'X'강퇴 'N'은 거절
							flag 'Y' 찬 'N' 반 'C' 중립(사회), 'NULL' -->
							<c:if test="${item.flag=='C'}">
								<span class = "alert alert-success" >토론을 개설했습니다.</span>
							</c:if>
							<c:if test="${item.request=='Y' and item.flag!='C'}">
								<span class = "alert alert-success" >토론에 참여했습니다.</span>
							</c:if>
							<c:if test="${item.request=='N'}">
								<span class = "alert alert-error" >토론 참여를 거절당했습니다.</span>
							</c:if>
							<c:if test="${item.request=='I'}">
								<span class = "alert alert-info" >${item.e_mail} 님이  초대했습니다.</span>
							</c:if>
							<c:if test="${item.request=='D'}">
								<span class = "alert alert-info" >토론 참여를 요청했습니다.</span>
							</c:if>
							<c:if test="${item.request=='X'}">
								<span class = "alert alert-error" >토론에서 추방되었습니다.</span>
							</c:if>
							<c:if test="${item.request=='X'}">
								<span class = "alert alert-error" >토론에서 추방되었습니다.</span>
							</c:if>
							<c:if test="${item.close=='C'}">
								<span class = "alert alert-error" >토론이 종료되었습니다.</span>
							</c:if>
							<span class="label pull-right"><i class="icon-calendar"></i> ${item.p_date} </span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>

