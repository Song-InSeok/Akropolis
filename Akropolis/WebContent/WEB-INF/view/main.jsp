<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Akropolis/css/main.css" rel="stylesheet" type="text/css"> 
	<script type="text/javascript">
		$(function() {
			$("#searchBar").find("li").eq(0).click(function() {
				alert("Hot page");
				<%System.out.println("asdasd");%>
			});
			$("#searchBar").find("li").eq(1).click(function() {
				alert("Lately page");
			});
			$("#searchBar").find("li").eq(2).click(function() {
				alert("Search result page");
			});
		});
	</script>
</head>
<body>
	<div class="container">
		<div id="mainLogo">
			<input type="button" id="signUpBtn" onclick="window.open('http://www.facebook.com')">
		</div>
		<div id="mainContents">
			<div id="searchBar">
				<ul class="nav nav-tabs">
	 				<li>
						<input type="button" name="hot" value="Hot" class="btn btn-success">
					</li>
					<li>
						<input type="button" name="lately" value="Lately" class="btn btn-success">
					</li>
					<li>	
						<input type="text" name="serarch" placeholder="Debate topics" class="search-query span7" id="search">
						<button type="button" class="btn"><i class="icon-search"></i></button>
					</li>
				</ul>
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

