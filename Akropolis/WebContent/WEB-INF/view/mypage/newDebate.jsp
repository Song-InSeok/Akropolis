<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="page" content="newDebate" />
<meta charset="UTF-8">
<title>토론열기</title>
<link href="/Akropolis/css/newdebate.css" rel="stylesheet"
	type="text/css">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript">
	$(document)
			.ready(
					function() {
						//******************************************************************************
						// 상세검색 달력 스크립트
						//******************************************************************************
						var clareCalendar = {
							monthNamesShort : [ '1월', '2월', '3월', '4월', '5월',
									'6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
							dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
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
						$("#fromDt").datepicker(clareCalendar);
						$("#toDt").datepicker(clareCalendar);
						$("img.ui-datepicker-trigger")
								.attr("style",
										"margin-left:5px; vertical-align:middle; cursor:pointer;"); //이미지버튼 style적용
						$("#ui-datepicker-div").hide(); //자동으로 생성되는 div객체 숨김  
					});
</script>
</head>

<body>
	<div id="contents">
		<form action="newDebate.ap" method="post">
			<fieldset>
				<legend>토론열기</legend>
				<label class="name">주제 :</label> <input type="text" name="mTopic">
				<div class="tags">
					<label class="name">태그 :</label> <input type="text" class="tag"
						name="tag"> <input type="text" class="tag" name="tag">
					<input type="text" class="tag" name="tag"> <br /><label class="name">태그추가</label> 
					<button name="add_tag" class="btn">
						<i class="icon-plus"></i>
					</button>
				</div>

				<hr>
				<label class="name">소주제 :</label>
				<div id="sub_subject">
					<table>
						<tbody>
							<tr>
								<th>1</th>
								<td>거북이는 토끼보다 느리다?</td>
								<td>
									<button class="btn" onclick="location.href='#'">
										<img src="/Akropolis/img/penIcon.png" class="img-rounded "
											alt="편집">
									</button>
								</td>
							</tr>

							<tr>
								<td></td>
								<td colspan="2">
									<div class="date">
										시작 : <input name="sDate" class="short" type="text" id="fromDt"
											size="8" maxlength="5" title="시작일자">
											H :
											<select class="tag" name="sHour">
											<% for(int i=0; i<24;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											M : <select class="tag" name="sMin">
											<% for(int i=0; i<60;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											<br /> 종료 : <input
											name="eDate" class="short" type="text" id="toDt" size="8"
											maxlength="8" title="종료일자">
											H :
											<select class="tag" name="eHour">
											<% for(int i=0; i<24;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											M : <select class="tag" name="eMin">
											<% for(int i=0; i<60;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
									</div>
								</td>
							</tr>
							
							<tr>
								<th>2</th>
								<td>거북이는 토끼보다 똑똑하다?</td>
								<td>
									<button class="btn" onclick="location.href='#'">
										<img src="/Akropolis/img/penIcon.png" alt="편집">
									</button>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<div class="date">
										시작 : <input name="sDate" class="short" type="text" id="fromDt"
											size="8" maxlength="5" title="시작일자">
											H :
											<select class="tag" name="sHour">
											<% for(int i=0; i<24;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											M : <select class="tag" name="sMin">
											<% for(int i=0; i<60;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											<br /> 종료 : <input
											name="eDate" class="short" type="text" id="toDt" size="8"
											maxlength="8" title="종료일자">
											H :
											<select class="tag" name="eHour">
											<% for(int i=0; i<24;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											M : <select class="tag" name="eMin">
											<% for(int i=0; i<60;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
									</div>
								</td>
							</tr>
							
						</tbody>
						<tfoot id="add">
							<tr>
								<th>3</th>
								<td colspan="2"><input type='text' size='50' class='sub'>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2">
									<div class="date">
										시작 : <input name="sDate" class="short" type="text" id="fromDt"
											size="8" maxlength="5" title="시작일자">
											H :
											<select class="tag" name="sHour">
											<% for(int i=0; i<24;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											M : <select class="tag" name="sMin">
											<% for(int i=0; i<60;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											<br /> 종료 : <input
											name="eDate" class="short" type="text" id="toDt" size="8"
											maxlength="8" title="종료일자">
											H :
											<select class="tag" name="eHour">
											<% for(int i=0; i<24;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
											M : <select class="tag" name="eMin">
											<% for(int i=0; i<60;i++) {%>
											<option><%if(i<10){%>
												0<%}%><%=i%></option>
											<%}%>
											</select> 
									</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><button class="btn" onclick="location.href='#'">OK</button></td>
							</tr>
						</tfoot>

					</table>
					<hr>
				</div>

				<label class="name">참여자초대 : <input type="checkbox" name="check">
					 Yes
				</label>
				<div id="regist">
					<a href="#"><button type="submit" class="btn">등록</button></a>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>