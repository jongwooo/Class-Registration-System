<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>명지대학교 수강신청 시스템</title>
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
</head>

<body>
	<!-- NavBar -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="/Class_Registration_System/class.jsp?id=<%= request.getParameter("id") %>">
			<img src="image/mju_logo.gif" alt="명지대 로고" width="30px" height="30px">
			<small style="font-family:Sunflower;">명지대학교 수강신청 시스템</small>
		</a>
		<!-- Print UserId -->
		<a href="/Class_Registration_System/login.jsp" class="btn btn-outline-primary btn-sm">로그아웃</a>
	</nav>

	<!-- Select Class -->
	<div class="container">
		<p class="text-right">
			<small style="font-family:Sunflower;"><%= request.getParameter("id") %> 님, 반갑습니다!</small>
		</p>
		<div class="row pl-3">
			<select name="campus" id="campus" onchange="campusChange()">
				<option value="select">캠퍼스 선택</option>
				<option value="용인캠퍼스">용인캠퍼스</option>
				<option value="서울캠퍼스">서울캠퍼스</option>
			</select>
			<select name="college" id="college">
				<option>분류 선택</option>
			</select>
			<select name="department" id="department">
				<option>분류 선택</option>
			</select>
		</div>
		<hr>
	</div>
	
  <!-- JS Files -->
	<script type="text/javascript" src="class.js"></script>

</body>

</html>
