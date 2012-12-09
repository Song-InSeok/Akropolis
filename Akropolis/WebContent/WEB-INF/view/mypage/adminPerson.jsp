<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta name="page" content="adminPerson" />
<meta charset="UTF-8">
<script type="text/javascript">
		$(function() {
			$(".rep_top_btn").click(function(){
				if(!confirm("대상을 강제퇴장 하시겠습니까?")){
					return false;
				};
			});

			$(".access_button").click(function(){
				if(!confirm("참여를 수락 하시겠습니까?")){
					return false;
				};
			});
			
		});
</script>
<title>참여자관리</title>
<link href="/Akropolis/css/adminPerson.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div class="accordion" id="accordion2">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#Request">
					토론 참여자
					</a>
				</div>
				<div id="Request" class="accordion-body collapse in">
					<div class="accordion-inner">
						<c:forEach items="${adminmanager.userList }" var="usr">
								<button id="y_btn" type="button" class="btn btn-primary disabled">${usr.name }</button>
						</c:forEach>
						
					</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#Participant">
					토론 참여 신청자
					</a>
				</div>
				<div id="Participant" class="accordion-body collapse">
					<div class="accordion-inner">
						<c:forEach items="${adminmanager.partList }" var="ptl">
							<form id="accessReq" method="POST">
								<input type="hidden" name = "mtmt" value="${ptl.mt_id }"/>
								<input type="hidden" name = "e_mail" value="${ptl.e_mail }"/>
								<button id="accessbtn" type="submit" class="btn btn-primary access_button" name="post_type" value="access">${ptl.e_mail }</button>
							</form>
						</c:forEach>					
					</div>
				</div>
			</div>
		</div>
		<div class="accordion" id="accordion3">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#Report">
					신고 목록
					</a>
				</div>
				<div id="Report" class="accordion-body collapse in">
					<div class="accordion-inner">
						<c:forEach items="${adminmanager.reportList }" var="rep">
							<div class="alert alert-error">
								<form id="reportForm" class="reportban" method="POST">
								<div class = "report_top">
									<span class="label label-info rep_top_label">${rep.e_mail }</span>
									<span class="label label-important rep_top_label">${rep.reported }</span>
									<button class = "btn btn-mini btn-inverse rep_top_btn" type="submit" name="post_type" value="ban">강제 퇴장</button>
								</div>
								<div class="report_bot">
									${rep.content }
									<input type="hidden" name = "mtmt" value="${adminmanager.mt_id}"/>
									<input type="hidden" name = "e_mail" value="${rep.reported }"/>
									<input type="hidden" name = "rep_id" value="${rep.report_id }"/>
								</div>
							</form>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>