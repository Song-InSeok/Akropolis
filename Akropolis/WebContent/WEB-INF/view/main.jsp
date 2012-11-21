<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Akropolis </title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet" type="text/css"> 
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div id="mainLogo">
			<input type="button" id="signUpBtn" onclick="window.open('http://www.facebook.com')">
		</div>
		<div id="mainContents">
			<div id="searchBar">
			 	<form method="post" action="#" class="navbar-form">
					<ul class="nav nav-tabs">
	 					<li>
							 <input type="submit" name="hot" value="Hot" class="btn btn-success">
						</li>
						<li>
							 <input type="submit" name="lately" value="Lately" class="btn btn-success">
						</li>
						<li>	
							 <input type="text" name="serarch" placeholder="Debate topics" class="search-query span7" id="search">
							 <button type="submit" class="btn"><i class="icon-search"></i></button>
						</li>
					</ul>
				</form>
			</div>
			<div id="searchResult">
				<ul>
					<li>
						<a href="#">topic1</a>
						<div class="progress">
							<div class="bar" style="width: 90%;"></div>
							<div class="bar bar-danger" style="width: 10%;"></div>
						</div>
					</li>
					<li>
						<a href="#">topic2</a>
						<div class="progress">
							<div class="bar" style="width: 50%;"></div>
							<div class="bar bar-danger" style="width: 50%;"></div>
						</div>
					</li>
					<li>
						<a href="#">topic3</a>
						<div class="progress">
							<div class="bar" style="width: 60%;"></div>
							<div class="bar bar-danger" style="width: 40%;"></div>
						</div>
					</li>
					<li>
						<a href="#">topic4</a>
						<div class="progress">
							<div class="bar" style="width: 30%;"></div>
							<div class="bar bar-danger" style="width: 70%;"></div>
						</div>
					</li>
					<li>
						<a href="#">topic5</a>
						<div class="progress">
							<div class="bar" style="width: 45%;"></div>
							<div class="bar bar-danger" style="width: 55%;"></div>
						</div>
					</li>
					<li>
						<a href="#">topic6</a>
						<div class="progress">
							<div class="bar" style="width: 75%;"></div>
							<div class="bar bar-danger" style="width: 25%;"></div>
						</div>
					</li>
				</ul>
				<div class="pagination pagination-centered">
					<ul>
					    <li><a href="#"><i class="icon-chevron-left"></i></a></li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
				   		<li><a href="#"><i class="icon-chevron-right"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

