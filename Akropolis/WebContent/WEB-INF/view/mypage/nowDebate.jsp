<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="page" content="adminDebate" />
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
				<label class="name">목 록</label>
				<div id="debate_list">
					<ul>
						<c:forEach var="topic" items="${model.topic}">
							<li>${topic}</li>
						</c:forEach>
					</ul>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>