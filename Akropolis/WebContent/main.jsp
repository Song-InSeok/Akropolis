<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Akropolis</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
  <jsp:include page="share/header.jsp"></jsp:include>
  
  <div class="container">
  	<div id="mainlogo">
  		<img src="./img/logo.png" alt="Main Image">
	</div>
	<div id="mainContents">
  		<div id="searchBar">
  		</div>
  		<div id="searchResult">
  			<div class="content">
  			</div>
  		</div>
	</div>
  </div>
  <jsp:include page="share/footer.jsp"></jsp:include>
</body>
</html>

