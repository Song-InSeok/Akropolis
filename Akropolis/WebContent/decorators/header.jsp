<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title><decorator:title default="Akropolis"/></title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/Akropolis/css/bootstrap.min.css" media="all" />
	<link rel="stylesheet" type="text/css" href="/Akropolis/css/header.css" media="all" />
	<decorator:head />
</head>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
					<li><a href="/Akropolis/main.ap">Home</a></li>
					<li><a href="/Akropolis/mypage/profile.ap">My Page</a></li>
					<li><a href="#">About</a></li>
				</ul>
				<c:url value="https://www.facebook.com/dialog/oauth" var="login_url" scope="request">
					<c:param name="client_id">${initParam.appID}</c:param>
					<c:param name="redirect_uri">${initParam.callback }</c:param>
					<c:param name="state">user_education_history</c:param>
				</c:url>
				<a href="${login_url }" class="pull-right"><img src="/Akropolis/img/facebook-logo.png" alt="Facebook" /></a>
				<form action="" method="post" class="form-search nav-search pull-right">
					<div class="input-prepend">
						<button type="submit" class="btn"><i class="icon-search"></i></button>
						<input type="text" name="search" id="search"
							placeholder="Search Text..." class="input-large search-query" />
					</div>
				</form>
			</div>
		</div>
		<hr/>
		<div id="content">
			<decorator:body />
		</div>
	</div>
</body>
</html>