<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="page" content="nowDebate" />
<meta charset="UTF-8">
<title>참여중인토론</title>
<link href="/Akropolis/css/nowdebate.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="contents">
		<form>
			<fieldset>
				<legend>참여중인토론</legend>
				<div id="debate_list">
						<c:forEach var="topic" items="${model.topic}">

							<div class="alert alert-block" style="width: 500px;">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<h4><a href="/Akropolis/debate.ap?mt=${topic.getMt_id()}">${topic.getMTopic()}
									(Topic_No. ${topic.getMt_id()})</a> <c:choose>
									<c:when test="${topic.getEmail() eq model.user.getEmail()}">
										<span class="label label-important">myDebate</span>
									</c:when>
									<c:otherwise><span class="label label-success">participate</span></c:otherwise>
								</c:choose></h4>
								개설자 : ${topic.getEmail()}
							</div>
						</c:forEach>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>