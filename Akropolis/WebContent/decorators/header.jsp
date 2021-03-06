<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="func"%>
<!DOCTYPE html>
<html>
<head>
	<c:url value="https://www.facebook.com/dialog/oauth" var="login_url"
		scope="request">
		<c:param name="client_id">${initParam.appID}</c:param>
		<c:param name="redirect_uri">${initParam.callback }</c:param>
		<c:param name="display">popup</c:param>
		<c:param name="scope">${initParam.scope }</c:param>
	</c:url>
	<title><decorator:title default="Akropolis"/></title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script src="/Akropolis/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/Akropolis/js/header.js"></script>
	<script type="text/javascript">
		$(function(){
			$("img[alt=Facebook]").click(function(e){
				window.open("${login_url}","LoginWindow","location=1,scrollbars=1,width="+popupWidth+",height="+popupHeight+",left="+xPosition+",top="+yPosition);
				e.preventDefault();
			});
		});
	</script>
	<link rel="stylesheet" type="text/css" href="/Akropolis/css/bootstrap.min.css" media="all" />
	<link rel="stylesheet" type="text/css" href="/Akropolis/css/header.css" media="all" />
	<link rel="shortcut icon" href="/Akropolis/img/favicon.ico" />
	<decorator:head />
</head>
<body>
	<div class="container">
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<ul class="nav">
						<li><a href="/Akropolis/main.ap">Home</a></li>
						<li><a href="/Akropolis/mypage/profile.ap">My Page</a></li>
						<!--li><a href="">About</a></li-->
					</ul>
					<ul class="nav pull-right header-right">
					<!-- 
						<li>
							<form action="" method="post"
								class="form-search nav-search pull-right">
								<div class="input-prepend">
									<button type="submit" class="btn">
										<i class="icon-search"></i>
									</button>
									<input type="text" name="search" id="search"
										placeholder="Search Text..." class="input-large search-query" />
								</div>
							</form>
						</li>
					-->
						<c:choose>
							<c:when test="${empty user}">
								<li>
									<a href="${func:escapeXml(login_url) }" target="_blank"><img src="/Akropolis/img/facebook-logo.png" alt="Facebook" /></a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="dropdown"><a class="dropdown-toggle" id="dLabel"
									role="button" data-toggle="dropdown" href="#">${user.name } <img
										src="${user.photo }"
										class="img-rounded" alt="profile" width="30" height="30" />
								</a>
									<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
										<li><a href="/Akropolis/logout.ap" tabindex="-1">로그아웃</a></li>
									</ul>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
		<hr/>
		<div id="content">
			<decorator:body />
		</div>
		<div id="fb-root"></div>
	</div>
</body>
</html>