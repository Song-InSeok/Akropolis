<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> --%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="/Akropolis/css/debate.css" rel="stylesheet" type="text/css">
	<c:set value="${debatemanager.logPt.request }" var="req"></c:set>
	<c:set value="${debatemanager.isPt }" var="ispt"/>
	<c:set value="${debatemanager.isLogin }" var = "islog"/>
	<script type="text/javascript">
		$(function() {
			$("#message_btn").append("asdf");
			
			$("#submit_button").click(function(){
				if(confirm("content")){
					$("#chat_form").submit();
				}
			});
			
			if('${req}'=='Y'){
				alert('${req}');
				$("#chat_bot").addClass("back_blue");
				$("#submit_button").addClass("btn-primary");
				$("#message_bot").hide();
			}else if('${req}'=='N'){
				$("#chat_bot").addClass("back_red");
				$("#submit_button").addClass("btn-danger");
				$("#message_bot").hide();

			}else if('${req}'=='C'){
				$("#chat_bot").addClass("back_green");
				$("#submit_button").addClass("btn-success");
				$("#message_bot").hide();

			}else if('${req}'=='D'){
				$("#chat_bot").hide();
				$("#message_bot").hide();
				$("#message_btn").addClass("btn-primary");
				$("#message_btn").addClass("disabled");
				$("#message_btn").append("참가 요청이 진행중입니다");
				
			}else if('${req}'=='X'){
				$("#chat_bot").hide();
				$("#message_btn").addClass("btn-danger");
				$("#message_btn").addClass("disabled");
				$("#message_btn").appent("토론에서 추방당하셨습니다.");
			}else if('${req}'=='R'){
				$("#chat_bot").hide();	
				$("#message_btn").addClass("btn-success");
				$("#message_btn").appent("사회자로부터 초대된 토론입니다.");
			}else{
				$("#chat_bot").hide();	
			}
			
			$(".progess").find(".bar").eq(0).click(function(){
				alert();
			});
			$(".progress").find(".bar").eq(1).click(function(){
				alert('${req}');
			});
		});
	</script>
	<title>Debate Title from DB</title>
</head>
<body>
	 
	<div id="main_topic">
		<div id="main_topic_top"><h3>${debatemanager.mt.mt_title }</h3></div>
		<div id="main_topic_bot">
			<button id="y_btn" type="button" class="btn btn-primary yn_btn" value="YES">찬성</button>
			<div class="progress yn_bar">
				<c:if test="${(debatemanager.mt.agree+debatemanager.mt.disagree)==0 }">
				<div class="bar progress-info flag_bar1" style="width : 50%">${debatemanager.mt.agree }</div>
				<div class="bar bar-danger flag_bar2" style="width:50%">${debatemanager.mt.disagree }</div>
				</c:if>
				<c:if test="${(debatemanager.mt.agree+debatemanager.mt.disagree)!=0 }">
				<div class="bar progress-info flag_bar1" style="width: ${100*debatemanager.mt.agree/(debatemanager.mt.agree+debatemanager.mt.disagree)}%;">${debatemanager.mt.agree }</div>
				<div class="bar bar-danger flag_bar2" style="width: ${100*debatemanager.mt.disagree/(debatemanager.mt.agree+debatemanager.mt.disagree)}%;">${debatemanager.mt.disagree }</div>
				</c:if>
			</div>
			<button id="y_btn" type="button" class="btn btn-danger yn_btn" value="NO">반대</button>
		</div>
	</div>
	
	<div id="debate_border">
		<div id="debate_border_left">
			<div id="sub_topics">
				<ul class="nav nav-list">
					<c:forEach var="SubTopic" items="${debatemanager.stList }">
						<c:choose>
							<c:when test="${debatemanager.st==SubTopic.sub_id }">
								<li class="active"><a href="http://localhost:8080/Akropolis/debate.ap?mt=${SubTopic.mt_id }&st=${SubTopic.sub_id}">${SubTopic.sub_title}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="http://localhost:8080/Akropolis/debate.ap?mt=${SubTopic.mt_id }&st=${SubTopic.sub_id}">${SubTopic.sub_title}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
			<div id="similer_topics">
				<ul class="nav nav-list"><li class="active"><a href="#">sim topic 1</a></li>
					<li><a href="#">sim topic 2</a></li>
					<li><a href="#">sim topic 3</a></li>
					<li><a href="#">${debatemanager.stList[param.st-1].sub_title }</a></li>
				</ul>
			</div>
		</div>
		<div id="debate_border_right">
			<div id="ing_debate">
				<div id="sub_title">
				<c:forEach var="SubTopic" items="${debatemanager.stList }">
					<c:if test="${debatemanager.st==SubTopic.sub_id }"><a>${SubTopic.sub_title }</a></c:if>
				</c:forEach>
				</div>
				<div id="opinions">
					<ul>
						<c:forEach var="opi" items="${debatemanager.opList }">
							<c:choose>
								<c:when test="${opi.flag=='Y'}"><li>
									<div class="alert-info blue_opinion">
									<div class="op_prof"><img class = "op_photo" src="${opi.photo }">
									<div class="prof_btn"><i class="icon-thumbs-up"></i><i class="icon-thumbs-down"></i></div></div>
									<div class="opinion"><a class="name">${opi.name }</a>
									<a class="id">${opi.e_mail }</a><br>
									<a>${opi.content }</a></div></div>
								</li><li><br/></li></c:when>
								
								<c:when test="${opi.flag=='N'}"><li>
									<div class="alert-error red_opinion">
									<div class="opinion"><a class="name">${opi.name }</a>
									<a class="id">${opi.e_mail }</a><br>
									<a>${opi.content }</a></div>
									<div class="op_prof"><img class = "op_photo" src="${opi.photo }">
									<div class="prof_btn">
									<i class="icon-thumbs-up"></i><a>${opi.honor }</a>
									<i class="icon-thumbs-down"></i><a>x</a>
									</div></div></div>
								</li></c:when>
								
								<c:when test="${opi.flag=='C'}">
								<li><div class="alert-success mid_opinion">
								<a class="name">${opi.name } </a><a class="id">${opi.e_mail }</a><br>
								<a>${opi.content }</a></div></li>
								</c:when>
							</c:choose>
						</c:forEach>
						<%--
						<li><div class="alert-error red_opinion"><div class="opinion"><a class="name">USER</a><a class="id">@asdf.com</a><br><a>red Opinion</a></div>
						<div class="op_prof"></div>
						</div></li>
						<li><div class="alert-info blue_opinion"><div class="op_prof"></div>
						<div class="opinion"><a class="name">USER</a>
						<a class="id">@asdf.com</a><br><a>Blue Opinion</a></div></div>
						</li>
						<li><div class="alert-success mid_opinion"><a class="name">USER</a><a class="id">@asdf.com</a>
						<br><a>MID OPINION</a>
						</div>
						</li>
						
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						<li class="alert-error red_opinion">red opinion</li>
						<li class="alert-info blue_opinion">blue opinion</li>
						<li class="alert-success mid_opinion">mid opinion</li>
						 --%>
					</ul>
				</div>
			</div>
			<%--여기부터 채탱윈도우 --%>
			<c:set value="${debatemanager.logPt.request }" var="req"/>
			<div id="chat_window" >
			<%-- <a>${debatemanager.subTopic.sub_close } ${debatemanager.isLogin } ${debatemanager.isPt } ${debatemanager.logPt.request }</a>
			--%>
				<%--<div id="chat_top">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#">blue</a></li>
						<li><a href="#">red</a></li>
					</ul></div> --%>
			<c:if test="${debatemanager.subTopic.sub_close=='O' }">
				<c:if test="${debatemanager.isLogin==1 }">
					<c:if test="${debatemanager.isPt==1 }">
						<div id="chat_bot" >
							<form id="chat_form" class="navbart-form pull-left" method="POST" action="debate.ap">
							<input type="hidden" name = "mtmt" value="${debatemanager.mt.mt_id }"/>
							<input type="hidden" name = "stst" value="${debatemanager.st }"/>
							<textarea id="submit_content"class="input-xxlarge chat_area" rows="5" name="chatarea1"></textarea>
							<button id="submit_button" type="submit" class="btn btn-large submit_btn" value="ok">OK</button>
							</form></div>
						<div id="message_bot" class = "back_grey">
							<button id="message_btn" type="button" class="btn btn-large msg_btn" value="mesbtn"></button>
						</div>
					</c:if>
					<c:if test="${debatemanager.isPt==0 }">
						<div id="message_bot" class = "back_grey">
							<button id="message_btn" type="button" class="btn btn-large btn-info msg_btn" value="mesbtn"></button>
						</div>
					</c:if>
				</c:if>
				<c:if test="${debatemanager.isLogin==0 }">
					<div id="message_bot" class = "back_grey">
					<button id="message_btn" type="button" class="btn btn-large msg_btn " value="mesbtn"></button>
					</div>
				</c:if>
			</c:if>
			<c:if test="${debatemanager.subTopic.sub_close=='C' }">
				<div id="message_bot" class = "back_grey">
					<button id="message_btn" type="button" class="btn btn-large msg_btn disabled" value="mesbtn"></button>
				</div>
				<a>close</a>
			</c:if>	
			</div>
		</div>
	</div>
</body>
</html>