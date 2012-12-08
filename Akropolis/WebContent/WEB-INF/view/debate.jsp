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
	<c:set value="${debatemanager.logPt.flag }" var = "loguserflag"/>
	<script type="text/javascript">
		$(function() {
			voteAlready = function(){
				alert("이미 투표 하셨습니다");
			};
			voteNo = function(){
				if(confirm("투표하시겠습니까?")){
					$("#no_form").submit();
				}
			};
			voteYes = function(){
				if(confirm("투표하시겠습니까?")){
					$("#yes_form").submit();
				}
			};
			
			
			$("#submit_button").click(function(){
				if(confirm("의견을 등록하시겠습니까?")){
					$("#chat_form").submit();
				}
			});
			if('${islog}'==1){
				if('${ispt}'==1){
					if('${req}'=='Y'){
						if('${loguserflag}'=='Y'){
							$("#chat_bot").addClass("back_blue");
							$("#submit_button").addClass("btn-primary");
							$("#message_bot").hide();
						}else if('${loguserflag}'=='N'){
							$("#chat_bot").addClass("back_red");
							$("#submit_button").addClass("btn-danger");
							$("#message_bot").hide();
						}else if('${loguserflag}'=='C'){
							$("#chat_bot").addClass("back_green");
							$("#submit_button").addClass("btn-success");
							$("#message_bot").hide();
						}else{
							$("#chat_bot").hide();
							$("#message_btn").addClass("btn-info");
							$("#message_btn").addClass("disabled");
							$("#message_btn").append("투표를 먼저 진행해 주세요.");
						}
					}else if('${req}'=='D'){
						$("#chat_bot").hide();
						$("#message_btn").addClass("btn-primary");
						$("#message_btn").addClass("disabled");
						$("#message_btn").append("참가 요청이 진행중입니다");
						
					}else if('${req}'=='X'){
						$("#chat_bot").hide();
						$("#message_btn").addClass("btn-danger");
						$("#message_btn").addClass("disabled");
						$("#message_btn").append("토론에서 추방당하셨습니다.");
					}else if('${req}'=='I'){
						$("#chat_bot").hide();	
						$("#message_btn").addClass("btn-success");
						$("#message_btn").append("사회자로부터 초대된 토론입니다.");
						$("#message_btn").click(function(){
							if(confirm("토론에 참여 하시겠습니까?")){
								$("#msg_form").submit();
							}
						});
					}else if('${req}'=='B'){
						$("#chat_bot").hide();	
						$("#message_btn").addClass("btn-info");
						$("#message_btn").append("토론 참여 신청");
						$("#message_btn").click(function(){
							if(confirm("토론에 참여를 신청하시겠습니까?")){
								$("#msg_form").submit();
							}
						});
					}else{
						$("#chat_bot").hide();
					}
					
					if('${loguserflag}'=='Y'||'${loguserflag}'=='N'||'${loguserflag}'=='C'||'${loguserflag}'=='B'){
						$(".yn_btn").addClass("disabled");
						//$(".yn_btn").attr("type","button");
						$(".yn_btn").click(voteAlready);
					}else{
						$("#y_btn").click(voteYes);
						$("#n_btn").click(voteNo);
					}
				}else{
					$("#y_btn").click(voteYes);
					$("#n_btn").click(voteNo);
					$("#chat_bot").hide();	
					$("#message_btn").addClass("btn-info");
					$("#message_btn").append("토론 참여 신청");
					$("#message_btn").click(function(){
						if(confirm("토론에 참여를 신청하시겠습니까?")){
							$("#request_form").submit();
						}
					});
				}
			}else{
				$(".yn_btn").addClass("disabled");
				//$(".yn_btn").attr("type","button");
				$(".yn_btn").click(function(){
					alert("투표하시려면 로그인 하셔야 합니다.");
				});
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
	 
	<div id="main_topic" class="container-fluid">
		<div id="main_topic_top"><p class="lead"><strong>${debatemanager.mt.mt_title }</strong></p></div>
		<div id="main_topic_bot">
		<form id="yes_form" method="POST" action="debate.ap">
			<input type="hidden" name = "mtmt" value="${debatemanager.mt.mt_id }"/>
			<input type="hidden" name = "stst" value="${debatemanager.st }"/>
			<input type="hidden" name = "post_type" value="yes_btn"/>
			<button id="y_btn" type="button" class="btn btn-primary yn_btn" value="yesbtn">찬성</button>
		</form>
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
		<form id="no_form" method="POST" action="debate.ap">
			<input type="hidden" name = "mtmt" value="${debatemanager.mt.mt_id }"/>
			<input type="hidden" name = "stst" value="${debatemanager.st }"/>
			<input type="hidden" name = "post_type" value="no_btn"/>
			<button id="n_btn" type="button" class="btn btn-danger yn_btn" value="nobtn">반대</button>
		</form>
		</div>
	</div>
	
	<div id="debate_border">
		<div id="debate_border_left">
			<div id="sub_topics">
				<ul class="nav nav-list">
					<li class="nav-header">SubTopic</li>
					<li class="divider"></li>
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
				<ul class="nav nav-list">
					<li class="nav-header">RECOMMEND</li>
					<li class="divider"></li>
					<li class="active"><a href="#">sim topic 1</a></li>
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
								</li></c:when>
								
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
			<div id="chat_window" >
			<%--
			<a>sc=${debatemanager.subTopic.sub_close } islogin=${debatemanager.isLogin } ispt=${debatemanager.isPt } req=${debatemanager.logPt.request }</a>
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
							<input type="hidden" name = "post_type" value="add_opinion"/>
							<textarea id="submit_content"class="input-xxlarge chat_area" rows="5" name="chatarea1"></textarea>
							<button id="submit_button" type="button" class="btn btn-large submit_btn" value="ok" name="btn">OK</button>
							</form></div>
						<div id="message_bot" class = "back_grey">
							<form id="msg_form" class="navbart-form pull-left" method="POST" action="debate.ap">
							<input type="hidden" name = "mtmt" value="${debatemanager.mt.mt_id }"/>
							<input type="hidden" name = "stst" value="${debatemanager.st }"/>
							<c:choose>
								<c:when test="${debatemanager.logPt.request=='B' }">
									<input type="hidden" name="post_type" value = "request_join"/>
								</c:when>
								<c:otherwise>
									<input type="hidden" name = "post_type" value="access_join"/>
								</c:otherwise>
							</c:choose>
							<button id="message_btn" type="button" class="btn btn-large msg_btn" value="mesbtn"></button>
							</form>
						</div>
					</c:if>
					<c:if test="${debatemanager.isPt==0 }">
						<div id="message_bot" class = "back_grey">
							<form id="request_form" class="navbart-form pull-left" method="POST" action="debate.ap">
							<input type="hidden" name = "mtmt" value="${debatemanager.mt.mt_id }"/>
							<input type="hidden" name = "stst" value="${debatemanager.st }"/>
							<input type="hidden" name = "post_type" value="request_join"/>
							<button id="message_btn" type="button" class="btn btn-large btn-info msg_btn" value="block_btn">
							</button>
							</form>
						</div>
					</c:if>
				</c:if>
				<c:if test="${debatemanager.isLogin==0 }">
					<div id="message_bot" class = "back_grey">
					<button id="message_btn" type="button" class="btn btn-large btn-info msg_btn disabled" value="block_btn">로그인 먼저 해주세요</button>
					</div>
				</c:if>
			</c:if>
			<c:if test="${debatemanager.subTopic.sub_close=='C' }">
				<div id="message_bot" class = "back_grey">
					<button id="message_btn" type="button" class="btn btn-large msg_btn disabled" value="block_btn">닫혀있는 주제입니다</button>
				</div>
				<a>close</a>
			</c:if>	
			</div>
		</div>
	</div>

</body>
</html>