<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.alsquare.com/tlds/el_function" prefix="fn"%>
<!DOCTYPE html>
<page:applyDecorator name="header">
<html>
<head>
	<title><decorator:title default="Akropolis"/></title>
	<link rel="stylesheet" type="text/css" href="/Akropolis/css/mypage.css" media="all" />
	<script type="text/javascript" src="/Akropolis/js/mypage.js"></script>
	<c:set var="pageId" scope="request">
		<decorator:getProperty property="meta.page" />
	</c:set>
	<decorator:head />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="leftMenu" class="span2">
				<ul class="nav nav-tabs nav-stacked">
					<li class="${pageId == 'profile'?'active':'' }"><a href="profile.ap">프로필</a></li>
					<li class="${pageId == 'nowDebate'?'active':'' }"><a href="nowDebate.ap">참여중인 토론</a></li>
					<c:choose>
						<c:when test="${fn:isOpen(user.email) }">
							<li class="${pageId == 'adminDebate'?'active':'' }"><a href="adminDebate.ap">주제 관리</a></li>
							<li class="${pageId == 'adminPerson'?'active':'' }"><a href="adminPerson.ap">참여자 관리</a></li>
						</c:when>
						<c:otherwise>
							<li class="${pageId == 'newDebate'?'active':'' }"><a href="newDebate.ap">토론 열기</a></li>
						</c:otherwise>
					</c:choose>
					<li class="${pageId == 'pastDebate'?'active':'' }"><a href="pastDebate.ap">지난토론</a></li>
					<li class="${pageId == 'timeline'?'active':'' }"><a href="timeline.ap">담벼락</a></li>
				</ul>
			</div>
			<div class="vline span1"></div>
			<div id="rightContent" class="span9">
				<decorator:body />
			</div>
		</div>
	</div>
</body>
</html>
</page:applyDecorator>