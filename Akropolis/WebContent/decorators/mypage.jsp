<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<!DOCTYPE html>
<page:applyDecorator name="header">
<html>
<head>
	<title><decorator:title default="Akropolis"/></title>
	<link rel="stylesheet" type="text/css" href="/Akropolis/css/mypage.css" media="all" />
	<decorator:head />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div id="leftMenu" class="span2">
				<ul class="nav nav-list well">
					<li class="active"><a href="">프로필</a></li>
					<li><a href="">참여중인 토론</a></li>
					<li><a href="">주제 관리</a></li>
					<li><a href="">참여자 관리</a></li>
					<li><a href="">지난토론</a></li>
					<li><a href="">담벼락</a></li>
					
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