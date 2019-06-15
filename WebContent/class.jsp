<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Vector"%>
<%@page import = "entity.ELecture" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>명지대학교 수강신청 시스템</title>
	<!-- favicon -->
	<link rel="shortcut icon" href="image/favicon.ico">
	<!-- CSS Files -->
	<link rel="stylesheet" href="style.css" type="text/css">
	<!-- Bootstrap CDN -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Questrial|Sunflower:300" rel="stylesheet">
	<!--Jquery CDN-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- JS Files -->
	<script type="text/javascript" src="class.js"></script>
	<script type="text/javascript" src="selectAll.js"></script>
</head>

<body>
	<!-- NavBar -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="class.do">
			<img src="image/mju_logo.gif" alt="명지대 로고" width="30px" height="30px">
			<small style="font-family: Sunflower;">명지대학교 수강신청 시스템</small>
		</a>
		<div class="text-right">
			<a href="myBag.do" class="btn btn-outline-primary btn-sm">책가방</a> <a href="logout.do" class="btn btn-outline-primary btn-sm">로그아웃</a>
		</div>
	</nav>

	<!-- Select Class -->
	<div class="container">
		<p class="text-right">
			<small style="font-family: Sunflower;"><%= session.getAttribute("name") %> 님, 반갑습니다!</small>
		</p>
		<hr>
	</div>

	<div class="container">
		<h5 class="lecture-list">강좌 검색</h5>
		<div class="row">
			<form class="text-center" style="margin: 0 auto;" action="lecture.do" method="post">
				<select name="campus" id="campus" onchange="campusChange()">
					<option value="캠퍼스 선택">캠퍼스 선택</option>
					<option value="용인캠퍼스">용인캠퍼스</option>
					<option value="서울캠퍼스">서울캠퍼스</option>
				</select> <select name="college" id="college">
					<option>분류 선택</option>
				</select> <select name="department" id="department">
					<option>분류 선택</option>
				</select>
				<input type="submit" class="btn btn-primary btn-sm" value="선택">
			</form>
		</div>
		<hr>
	</div>

	<div class="container">
		<%
			if (request.getParameter("campus") == null || request.getParameter("college") == null
					|| request.getParameter("department") == null) {
		%>
		<h5 class="lecture-list">강좌 선택</h5>
		<%
			} else {
		%>
		<h5 class="lecture-list">
			<%=request.getParameter("campus")%>
			/
			<%=request.getParameter("college")%>
			/
			<%=request.getParameter("department")%>
		</h5>
		<%
			}
		%>
	</div>
	<div class="container">
		<form method="post" name="lecture">
			<div class="text-right pb-2">
				<input type="submit" class="btn btn-info btn-sm" value="담기" onclick="javascript: lecture.action='addBag.do';">
				<input type="submit" class="btn btn-primary btn-sm" value="신청" onclick="javascript: lecture.action='addSincheong.do';">
			</div>
			<table class="table table-sm table-bordered table-hover table-condensed text-center">
				<thead>
					<tr>
						<th><input type="checkbox" name="lecture-all" class="lecture-all" onClick="select(lecture);"></th>
						<th>강좌 번호</th>
						<th>강좌명</th>
						<th>담당 교수</th>
						<th>학점</th>
						<th>강의 시간</th>
					</tr>
				</thead>
				<tbody>
					<!-- Show Lectures -->
			  <% if(request.getAttribute("lectures") != null) {
					Object lectures = request.getAttribute("lectures");
					Vector<ELecture> items = (Vector<ELecture>)lectures;
					for(int index = 0;index < items.size();index++){
						String value = items.get(index).getLectureNum() + " " + items.get(index).getLectureName()
								+ " " + items.get(index).getProfessor() + " " + items.get(index).getCredit() + " " + items.get(index).getTime();
				%>
					<tr>
						<td><input type="checkbox" name="selectedLectures" value="<%= value %>" class="lecture"></td>
						<td><%= items.get(index).getLectureNum() %></td>
						<td><%= items.get(index).getLectureName() %></td>
						<td><%= items.get(index).getProfessor() %></td>
						<td><%= items.get(index).getCredit() %></td>
						<td><%= items.get(index).getTime() %></td>
					</tr>
				<%
					}
				 } else {

				} %>
				</tbody>
			</table>
		</form>
		<br>
		<br>
		<hr>
	</div>

</body>

</html>
