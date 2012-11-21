<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>토론관리</title>
<link href="/Akropolis/css/admindebate.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<div id="contents">

		<form>
			<fieldset>
				<legend>토론관리</legend>
				<div id="inform">
					<label class="name">주제 :</label>
					<p id="subject">성형 수술 해도 된다?</p>
					<br /> <label class="name">태그 :</label>
					<p>성형, 의학, 외모</p>
					<a href="#" id="add"><button type="submit" name="tag" class="btn">
							<i class="icon-plus"></i>
						</button></a><br /> <label class="name">소주제 :</label>
					<div id="sub_subject">
						<table>
							<tbody>
								<tr>
									<th>1</th>
									<td><a href="#">토끼보다 느리다?</a></td>
								</tr>
								<tr>
									<th>2</th>
									<td><a href="#" class="now">거북이는 토끼보다 똑똑하다?</a></td>
								<tr>
									<td colspan="2">
										<div class="date">
											<input type="text" name="start" class="short"
												value="12/03/2012"><a href="#"> <img
												src="/Akropolis/img/calender.PNG" alt="달력"></a>
										</div>
									</td>
								</tr>

								<tr>
									<th>3</th>
									<td><a href="#">거북이는 발이 3개다???????잉?</a></td>
								</tr>

								<tr>
									<td colspan="2"><hr><a href="#" id="add"><button
												type="submit" name="sub_subject" class="btn">
												<i class="icon-plus"></i>
											</button></a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div id="finish">
					<textarea rows="5" id="finish_ment"></textarea>
					<a href="#"><button type="submit" class="btn">토론종료</button></a>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>