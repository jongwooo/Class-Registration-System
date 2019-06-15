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
	<script type="text/javascript" src="selectAll.js"></script>
</head>

<body>
	<!-- NavBar -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="class.do">
			<img src="image/mju_logo.gif" alt="명지대 로고" width="30px" height="30px">
			<small style="font-family:Sunflower;">명지대학교 수강신청 시스템</small>
		</a>
		<div class="text-right">
			<a href="class.do" class="btn btn-outline-primary btn-sm">강좌 선택</a>
			<a href="logout.do" class="btn btn-outline-primary btn-sm">로그아웃</a>
		</div>
	</nav>

	<!-- My Bag -->
	<div class="container">
		<p class="text-right">
			<small style="font-family:Sunflower;"><%= session.getAttribute("name") %> 님, 반갑습니다!</small>
		</p>
		<hr>
	</div>
	<!-- Basket -->
	<div class="container">
		<h5 class="lecture-list">담은 강좌 목록</h5>
		<form method="post" name="bag">
			<div class="text-right pb-2">
				<input type="submit" class="btn btn-primary btn-sm" value="신청" onclick="javascript: bag.action='addMySincheong.do';">
				<input type="submit" class="btn btn-danger btn-sm" value="삭제" onclick="javascript: bag.action='removeBag.do';">
			</div>
			<table class="table table-sm table-bordered table-hover table-condensed text-center">
				<thead>
					<tr>
						<th><input type="checkbox" name="bag-all" class="bag-all"></th>
						<th>강좌 번호</th>
						<th>강좌명</th>
						<th>담당 교수</th>
						<th>학점</th>
						<th>강의 시간</th>
					</tr>
				</thead>
				<tbody>
					<!-- Show Lectures -->
					<% if(request.getAttribute("myBag") != null) {
					Object myBags = request.getAttribute("myBag");
					Vector<ELecture> bItems = (Vector<ELecture>)myBags;
					for(int index = 0;index < bItems.size();index++){
						String bValue = bItems.get(index).getLectureNum() + " " + bItems.get(index).getLectureName()
								+ " " + bItems.get(index).getProfessor() + " " + bItems.get(index).getCredit() + " " + bItems.get(index).getTime();
				%>
					<tr>
						<td><input type="checkbox" name="selectedLectures" value="<%= bValue %>" class="bag"></td>
						<td><%= bItems.get(index).getLectureNum() %></td>
						<td><%= bItems.get(index).getLectureName() %></td>
						<td><%= bItems.get(index).getProfessor() %></td>
						<td><%= bItems.get(index).getCredit() %></td>
						<td><%= bItems.get(index).getTime() %></td>
					</tr>
					<%
					}
				 } else {

				 }%>
				</tbody>
			</table>
		</form>
		<br>
		<br>
		<hr>
	</div>

	<!-- Sincheong -->
	<div class="container">
		<h5 class="lecture-list">신청 강좌 목록</h5>
		<form action="removeSincheong.do" method="post">
			<div class="text-right pb-2">
				<input type="submit" class="btn btn-danger btn-sm" value="삭제">
			</div>
			<table class="table table-sm table-bordered table-hover table-condensed text-center">
				<thead>
					<tr>
						<th><input type="checkbox" name="sincheong-all" class="sincheong-all"></th>
						<th>강좌 번호</th>
						<th>강좌명</th>
						<th>담당 교수</th>
						<th>학점</th>
						<th>강의 시간</th>
					</tr>
				</thead>
				<tbody>
					<!-- Show Lectures -->
					<% if(request.getAttribute("sincheong") != null) {
					Object sincheongs = request.getAttribute("sincheong");
					Vector<ELecture> sItems = (Vector<ELecture>)sincheongs;
					for(int index = 0;index < sItems.size();index++){
						String sValue = sItems.get(index).getLectureNum() + " " + sItems.get(index).getLectureName()
								+ " " + sItems.get(index).getProfessor() + " " + sItems.get(index).getCredit() + " " + sItems.get(index).getTime();
				%>
					<tr>
						<td><input type="checkbox" name="selectedLectures" value="<%= sValue %>" class="sincheong"></td>
						<td><%= sItems.get(index).getLectureNum() %></td>
						<td><%= sItems.get(index).getLectureName() %></td>
						<td><%= sItems.get(index).getProfessor() %></td>
						<td><%= sItems.get(index).getCredit() %></td>
						<td><%= sItems.get(index).getTime() %></td>
					</tr>
					<%
					}
				 } else {

				 }%>
				</tbody>
			</table>
		</form>
		<br>
		<br>
		<hr>
	</div>

</body>

</html>
