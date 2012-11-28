<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/debate.css" rel="stylesheet">
<title>Debate Title from DB</title>
</head>
<body>
	<div id="main_topic">asdf
	</div>
	
	<div id="debate_border">
		<div id="debate_border_left">
			<div id="sub_topics">
				<ul class="nav nav-list">
					<li><a href="#">sub topic 1</a></li>
					<li class="active"><a href="#">sub topic 2</a></li>
					<li><a href="#">sub topic 3</a></li>
					<c:forEach var="SubTopic" items="${debatemanager.stList }">
						<li>
						<a href="http://localhost:8080/Akropolis/debate.ap?mt=${param.mt }&st=${SubTopic.sub_id}">${SubTopic.sub_title}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div id="similer_topics">
				<ul class="nav nav-list"><li class="active"><a href="#">sim topic 1</a></li>
					<li><a href="#">sim topic 2</a></li>
					<li><a href="#">sim topic 3</a></li>
					<li><a href="#">${debatemanager.stList[param.st-1].sub_title }</a></li>
				</ul>
			</div>
		</div>
		<div id="debate_border_right">
			<div id="ing_debate">
				<div id="sub_title">${debatemanager.stList[param.st-1].sub_title }</div>
				<div id="opinions">
					<ul>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
					</ul>
				</div>
			</div>
			<div id="chat_window">
				<div id="chat_top">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#">blue</a></li>
						<li><a href="#">red</a></li>
					</ul></div>
				<div id="chat_bot">
					<form class="navbart-form pull-left">
						<textarea class="input-xxlarge marg_left" rows="2" name="chatarea"></textarea>
						<button type="submit" class="btn btn-primary btn-large submit_btn">OK</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>