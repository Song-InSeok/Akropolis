<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String option=request.getParameter("text"); 
System.out.println(option);
System.out.println(option);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<link href="/Akropolis/css/main.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		$(function(){
			$(".typeahead2").typeahead({
				source:function(query,process){
					return $.get('autocomplete.ap',{searchText:query,type:$("#test3 option:selected").val()},function(data){
						return process(data);
					});
				},
				minLength: 2,
				matcher: function(item){
					var pattern = "^"+this.query;
					var regexp = new RegExp(pattern,"gi");
					return regexp.test(item);
				}
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
					<c:if test="${model.option=='hot' or empty model.option}">
						<li class="active"> <a href="/Akropolis/main.ap?option=hot&page=1" id="hot">Hot</a> </li>
					  	<li> <a href="/Akropolis/main.ap?option=lately&page=1" id="lately">Lately</a> </li>
				  	</c:if>
				  	<c:if test="${model.option=='lately'}">
						<li> <a href="/Akropolis/main.ap?option=hot&page=1" id="hot">Hot</a> </li>
					  	<li class="active"> <a href="/Akropolis/main.ap?option=lately&page=1" id="lately">Lately</a> </li>
				  	</c:if>
			  		<c:if test="${model.option=='Title' or model.option=='Tag'}">
						<li> <a href="/Akropolis/main.ap?option=hot&page=1" id="hot">Hot</a> </li>
					  	<li> <a href="/Akropolis/main.ap?option=lately&page=1" id="lately">Lately</a> </li>
				  	</c:if>
					<li class="pull-right">
					  	<form method="POST">
						  <div class="input-prepend input-append">
								<select class="span2" name="searchOption" id="test3">
									<option value="Title">Title</option>
									<option value="Tag">Tag</option>
								</select>
								<input type="text" name="searchText" class="span5 typeahead2" placeholder="Input topic">
							<input type="submit" class="btn" value="Search">
						  </div>
						</form>
					</li>
				</ul>					
			</div>
			<div id="searchResult">
				<p class="alert alert-info pull-right span10">
					<span class="span3"> <strong> Total :  </strong>${model.result.total} </span>
					<span class="span3"> <strong> Selected Option : </strong>${model.option} </span>
					<span class="span3"> <strong> Text : </strong> ${model.text} </span>
				</p>
				<ul>
				<c:forEach var="debate" items="${model.result.topicList}">
					<li>
						<c:set var="agree" value="${debate.agree/(debate.disagree+debate.agree)*100}"></c:set> 
						<c:set var="disagree" value="${debate.disagree/(debate.disagree+debate.agree)*100}"></c:set> 
						<p class="lead"><a href="/Akropolis/debate.ap?mt=${debate.mt_id}">${debate.mt_title}</a></p>
						<div class="progress">
							<div class="bar" style="width: ${agree}%;">${debate.agree}</div>
							<div class="bar bar-danger" style="width: ${disagree}%;">${debate.disagree}</div>
						</div>
						<span class = "pull-left">${debate.e_mail}</span>
						<span class = "pull-right">${debate.date}</span>
					</li>
				</c:forEach>	
				</ul>
				<div class="pagination pagination-centered span12">
					<ul>
						<c:if test="${model.result.currentPage != 1}">
						    <li>
							    <a href="/Akropolis/main.ap?option=${model.option}&page=${model.result.currentPage-1}&text=${model.text}">
							    	<i class="icon-chevron-left"></i>
							    </a>
						    </li>
					    </c:if>
					    <c:forEach var="i" begin="${model.result.startPage}"  end="${model.result.endPage}">
						    <c:if test="${i == model.result.currentPage}">
					        	<li class="active">
					        		<a href="/Akropolis/main.ap?option=${model.option}&page=${i}&text=${model.text}">${i}</a>
					        	</li>
					      	</c:if>
					     	<c:if test="${i != model.result.currentPage}">
	          					<li>
	          						<a href="/Akropolis/main.ap?option=${model.option}&page=${i}&text=${model.text}">${i}</a>
	          					</li>
		      				</c:if>
					   	</c:forEach>
					   	<c:if test="${model.result.maxPage != 0 and model.result.currentPage != model.result.maxPage}">
					   		<li>
					   			<a href="/Akropolis/main.ap?option=${model.option}&page=${model.result.currentPage+1}&text=${model.text}">
					   				<i class="icon-chevron-right"></i>
					   			</a>
					   		</li>
					   	</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

