<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="page" content="pastDebate" />
<meta charset="UTF-8">
<title>지난토론</title>
<link href="/Akropolis/css/pastdebate.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="contents">
		<form>
			<fieldset>
				<legend>지난토론</legend>
				<label class="name">목 록</label>
				<div id="debate_list">
					<ul>
						<c:forEach var="topic" items="${model.topic}">
							<li><a href="/Akropolis/debate.ap?mt=${topic.getMt_id()}">${topic.getMTopic()}
									(mt_id :${topic.getMt_id()})</a></li>

						</c:forEach>
					</ul>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>