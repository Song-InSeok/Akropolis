<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="page" content="adminDebate" />
<meta charset="UTF-8">
<title>토론관리</title>
<link href="/Akropolis/css/admindebate.css" rel="stylesheet"
	type="text/css">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">
	var num = 2;
	var fDate = "fDate";
	var tDate = "tDate";
	$(function() {

		$("#contents input").attr("disabled", true);

		$(".input-append").find(".btn:first").click(
				function() {
					$(this).parents(".input-append").find("input").attr(
							"disabled", false);
				});
		$(".input-append").find(".btn:last").click(
				function() {
					$(this).parents(".input-append").find("input").attr(
							"disabled", true);
				});
		$("#addTag").click(
				function() {
					$("#tags").append($("#tagSecret").html());
					$(".input-append").find(".btn:first").click(
							function() {
								$(this).parents(".input-append").find("input")
										.attr("disabled", false);
							});
					$(".input-append").find(".btn:last").click(
							function() {
								$(this).parents(".input-append").find("input")
										.attr("disabled", true);
							});
				});

		$("#addSub")
				.click(
						function() {
							
							$("#contents").find("tfoot").append(
									$("#secretT").html());
							$("#contents").find(".dates").find("#tDate").attr("id",tDate+num);
							$("#contents").find(".dates").find("#fDate").attr("id",fDate+num);
							num++;
							//////////////////////////////////////////////
							var clareCalendar = {
								monthNamesShort : [ '1월', '2월', '3월', '4월',
										'5월', '6월', '7월', '8월', '9월', '10월',
										'11월', '12월' ],
								dayNamesMin : [ '일', '월', '화', '수', '목', '금',
										'토' ],
								weekHeader : 'Wk',
								dateFormat : 'yy-mm-dd', //형식(20120303)
								autoSize : false, //오토리사이즈(body등 상위태그의 설정에 따른다)
								changeMonth : true, //월변경가능
								changeYear : true, //년변경가능
								showMonthAfterYear : true, //년 뒤에 월 표시
								buttonImageOnly : true, //이미지표시
								buttonText : '달력선택', //버튼 텍스트 표시
								buttonImage : '/Akropolis/img/calender.PNG', //이미지주소
								showOn : "both", //엘리먼트와 이미지 동시 사용(both,button)
								yearRange : '1990:2020' //1990년부터 2020년까지
							};

							switch (num) {
							case 3:
								$("#fDate2").datepicker(clareCalendar);
								$("#tDate2").datepicker(clareCalendar);
								break;
							case 4:
								$("#fDate3").datepicker(clareCalendar);
								$("#tDate3").datepicker(clareCalendar);
								break;
							case 5:
								$("#fDate4").datepicker(clareCalendar);
								$("#tDate4").datepicker(clareCalendar);
								break;
							case 6:
								$("#fDate5").datepicker(clareCalendar);
								$("#tDate5").datepicker(clareCalendar);
								break;
							}

							$("img.ui-datepicker-trigger")
									.attr("style",
											"margin-left:5px; vertical-align:middle; cursor:pointer;"); //이미지버튼 style적용

							$("#ui-datepicker-div").hide(); //자동으로 생성되는 div객체 숨김  
							/////////////////////////////
							
							$("#secretT").find("th:first").text(num);
						});
	});
</script>
</head>

<body>
	<div id="contents">
		<form>
			<fieldset>
				<legend>토론관리</legend>
				<label class="name">주제 :</label>
				<p id="subject">${model.nowDebate.getMTopic()}</p>
				<br /> <label class="name">태그 :</label>
				<button type="button" name="tag" id="addTag">
					<i class="icon-plus"></i>
				</button>
				<br />
				<div id="tags">
					<c:forEach var="tag" items="${model.nowDebate.getTags()}">
						<div class="input-append">
							<input class="tag" id="appendedInputButton" name="tag"
								type="text" value="${tag.getTag()}">
							<button class="btn" style="width: 40px; padding: 4px;"
								type="button">수정</button>
							<button class="btn" style="width: 40px; padding: 4px;"
								type="button">OK</button>
						</div>
					</c:forEach>

				</div>


				<div id="sub_subject">
					<label class="name">소주제 :</label>
					<table>
						<tbody>
							<c:forEach var="subTopic" varStatus="i"
								items="${model.nowDebate.getSubtopics()}">
								<tr>
									<th>${i.count}</th>
									<td>${subTopic.getSub_title()}</td>
								</tr>
								<tr class="dates">
									<td colspan="2">시작 : <input type="text" name="start"
										size="19" maxlength="19" class="date"
										value="${subTopic.getStart_time()}">
									</td>
								</tr>
								<tr class="dates">
									<td colspan="2">종료 : <input type="text" name="start"
										size="19" maxlength="19" class="date"
										value="${subTopic.getEnd_time()}">
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
						</tfoot>
					</table>
					<div style="margin-left: 33px;">
						<button type="button" id="addSub" name="sub_subject"
							class="btn btn-success">
							<i class="icon-plus"></i>
						</button>

						<hr />
					</div>
				</div>

				<div id="finish">
					<label class="name">토론끝내기</label> <br />
					<textarea rows="5" id="finish_ment" placeholder="Write to Ment for Finish Debate"></textarea>
					<span style="margin-left: 180px;">
						<button type="submit" id="save" style="width: 86px;"
							class="btn btn-success">Save</button>
						<button type="submit" class="btn btn-danger">토론종료</button>
					</span>
				</div>
			</fieldset>
		</form>
	</div>

	<div id="tagSecret" style="display: none;">

		<div class="input-append">
			<input class="tag" id="appendedInputButton" name="tag" type="text">
			<button class="btn" style="width: 40px; padding: 4px;" type="button">수정</button>
			<button class="btn" style="width: 40px; padding: 4px;" type="button">OK</button>
		</div>

		<div id="subSecret" style="display: none;">
			<table>
				<tbody id="secretT">
					<tr>
						<th class="index">2</th>
						<td><input type="text" name="sub_title" class="input-large"
							placeholder="wirte to SubTopic"></td>
					</tr>
					<tr class="dates">
						<td colspan="2">
						시작 : <input name="sDate" class="date" type="text" size="10"
							id="fDate" maxlength="10" title="시작일자"> H : <select
							class="tag" name="sHour">
							<% for(int i=0; i<24;i++) {%>
							<option value="<%if(i<10){%>0<%}%><%=i%>">
								<%if(i<10){%>
								0<%}%><%=i%></option>
							<%}%>
						</select> M : <select class="tag" name="sMin">
							<% for(int i=0; i<60;i++) {%>
							<option value="<%if(i<10){%>0<%}%><%=i%>">
								<%if(i<10){%>
								0<%}%><%=i%></option>
							<%}%>
						</select> <br /> 종료 : <input name="eDate" class="date" type="text"
							id="tDate" size="10" maxlength="10" title="종료일자"> H : <select
							class="tag" name="eHour">
							<% for(int i=0; i<24;i++) {%>
							<option value="<%if(i<10){%>0<%}%><%=i%>">
								<%if(i<10){%>
								0<%}%><%=i%></option>
							<%}%>
						</select> M : <select class="tag" name="eMin">
							<% for(int i=0; i<60;i++) {%>
							<option value="<%if(i<10){%>0<%}%><%=i%>">
								<%if(i<10){%>
								0<%}%><%=i%></option>
							<%}%>
						</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>