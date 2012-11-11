<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Akropolis </title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src='jquery-1.8.2.min.js'></script>
	<style type="text/css">
		#mainLogo{
			  height: 300px;
			  background : url('./img/logo2.png') no-repeat left top;
			  background-size:100% 100%;
		}
		#signUpBtn {
			float : right;
			margin-top : 200px;
			margin-right : 20px;
			width : 350px;
			height : 70px;
			background : url('./img/facebook.png') no-repeat left top;
			background-size:100% 100%;
		}
		
		#signUpBtn:hover{
			background : url('./img/facebook2.png') no-repeat left top;
			background-size:100% 100%;
		}
		
		#mainContents{
			  height: 600px;
		}
		#search{
			margin-left:200px;
			width: 500px;
		}
		.nav li{
			margin-right:5px;
		}
	</style>
</head>
<body>
	<jsp:include page="share/header.jsp"></jsp:include>

	<div class="container">
		<div id="mainLogo">
			<input type="button" id="signUpBtn">
		</div>
		<div id="mainContents">
			<div id="searchBar">
			 	<form method="post" action="search.jsp" class="navbar-form">
					<ul class="nav nav-tabs">
	 					<li class="active">
							 <input type="submit" name="hot" value="Hot" class="btn btn-success">
						</li>
						<li>
							 <input type="submit" name="lately" value="Lately" class="btn btn-success">
						</li>
						<li>	
							 <input type="text" name="serarch" placeholder="Search" class="search-query" id="search">
						</li>
					</ul>
				</form>
			</div>
			<div id="searchResult">
				<div class="content">
					<ul>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="share/footer.jsp"></jsp:include>
</body>
</html>

