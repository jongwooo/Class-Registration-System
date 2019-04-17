<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명지대학교 수강신청 시스템</title>
<!-- CSS Files -->
<link rel="stylesheet" href="style.css" type="text/css">
<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">명지대학교 수강신청 시스템</a>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 center-align">
				<div class="card">
					<br>
					<h3 class="text-center">로그인</h3>
					<br>
					<form class="" action="" method="post">
						<div class="form-group row">
							<label for="InputUserId" class="col-md-2 col-form-label">아이디</label>
							<div class="col-md-10">
								<input type="text" class="form-control" id="InputUserId"
									placeholder="아이디">
							</div>
						</div>
						<div class="form-group row">
							<label for="InputPassword" class="col-md-2 col-form-label">비밀번호</label>
							<div class="col-md-10">
								<input type="password" class="form-control" id="InputPassword"
									placeholder="비밀번호">
							</div>
						</div>
						<p class="text-center">
							<input type="button" name="" value="로그인"
								class="btn btn-outline-info">
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
