<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="/Akropolis/css/main.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<div class="container">
		<div id="mainLogo">
			<input type="button" id="signUpBtn" onclick="window.open('http://www.facebook.com')">
		</div>
		<div id="mainContents">
			<div id="searchBar">
				<ul class="nav nav-tabs">
					<c:if test="${model.option=='hot' or empty model.option}">
						<li class="active">
					    	<a href="/Akropolis/main.ap?option=hot&page=1" id="hot">Hot</a>
					  	</li>
					  	<li>
					  		<a href="/Akropolis/main.ap?option=lately&page=1" id="lately">Lately</a>
					  	</li>
				  	</c:if>
				  	<c:if test="${model.option=='lately'}">
						<li>
					    	<a href="/Akropolis/main.ap?option=hot&page=1" id="hot">Hot</a>
					  	</li>
					  	<li class="active">
					  		<a href="/Akropolis/main.ap?option=lately&page=1" id="lately">Lately</a>
					  	</li>
				  	</c:if>
				</ul>
					
			</div>
			<div id="searchResult">
				<ul>
				<c:forEach var="debate" items="${model.result.topicList}">
					<li>
						<c:set var="agree" value="${debate.agree/(debate.disagree+debate.agree)*100}"></c:set> 
						<c:set var="disagree" value="${debate.disagree/(debate.disagree+debate.agree)*100}"></c:set> 
						<p class="lead" id="topic"><a href="#">${debate.mt_title}</a></p>
						<div class="progress">
							<div class="bar" style="width: ${agree}%;">${debate.agree}</div>
							<div class="bar bar-danger" style="width: ${disagree}%;">${debate.disagree}</div>
						</div>
						<span class = "pull-left">${debate.e_mail}</span>
						<span class = "pull-right">${debate.date}</span>
					</li>
				</c:forEach>	
				</ul>
			</div>
			<div class="pagination pagination-centered">
				<ul>
					<c:if test="${model.result.currentPage != 1}">
					    <li>
						    <a href="/Akropolis/main.ap?option=${model.option}&page=${model.result.currentPage-1}">
						    	<i class="icon-chevron-left"></i>
						    </a>
					    </li>
				    </c:if>
				    <c:forEach var="i" begin="${model.result.startPage}"  end="${model.result.endPage}">
					    <c:if test="${i == model.result.currentPage}">
				        	<li class="active">
				        		<a href="/Akropolis/main.ap?option=${model.option}&page=${i}">${i}</a>
				        	</li>
				      	</c:if>
				     	<c:if test="${i != model.result.currentPage}">
          					<li>
          						<a href="/Akropolis/main.ap?option=${model.option}&page=${i}">${i}</a>
          					</li>
	      				</c:if>
				   	</c:forEach>
				   	<c:if test="${model.result.currentPage != model.result.maxPage}">
				   		<li>
				   			<a href="/Akropolis/main.ap?option=${model.option}&page=${model.result.currentPage+1}">
				   				<i class="icon-chevron-right"></i>
				   			</a>
				   		</li>
				   	</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>

