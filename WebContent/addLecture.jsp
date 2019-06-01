<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");

	String userName = request.getParameter("name");
	String userName_en = java.net.URLEncoder.encode(userName, "UTF-8");

	String campus = request.getParameter("campus");
	String campus_en = java.net.URLEncoder.encode(campus, "UTF-8");

	String college = request.getParameter("college");
	String college_en = java.net.URLEncoder.encode(college, "UTF-8");

	String department = request.getParameter("department");
	String department_en = java.net.URLEncoder.encode(department, "UTF-8");

	String lectureNum = request.getParameter("lectureNum");

	String lectureName = request.getParameter("lectureName");
	String lectureName_en = java.net.URLEncoder.encode(lectureName, "UTF-8");

	String credit = request.getParameter("credit");
	String credit_en = java.net.URLEncoder.encode(credit, "UTF-8");

	String time = request.getParameter("time");
	String time_en = java.net.URLEncoder.encode(time, "UTF-8");

	String redirectUrl = "professor.jsp?id=" + id + "&name=" + userName_en + "&campus=" + campus
			+ "&college=" + college_en + "&department=" + department_en;

	String line = "\n" + lectureNum + " " + lectureName + " " + userName + " " + credit + " " + time;

	String filePath = application.getRealPath("/WEB-INF/data/" + campus + "/" + college) + "/" + department;

	try {
		FileWriter fw = new FileWriter(filePath, true);
		fw.write(line);
		fw.close();
	} catch (FileNotFoundException e) {
    out.println(line);
	}
%>
<script>
  var lectureName = '<%=lectureName%>'
  var redirectUrl = '<%=redirectUrl%>';
	alert(lectureName + ' 강좌를 생성했습니다!');
	location.href = redirectUrl;
</script>
