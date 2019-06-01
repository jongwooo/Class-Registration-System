<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%
    request.setCharacterEncoding("utf-8");
    String id  = request.getParameter("id");

    String userName  = request.getParameter("name");
    String userName_en = java.net.URLEncoder.encode(userName, "UTF-8");

    String campus = request.getParameter("campus");
    String campus_en = java.net.URLEncoder.encode(campus, "UTF-8");

    String college = request.getParameter("college");
    String college_en = java.net.URLEncoder.encode(college, "UTF-8");

    String department  = request.getParameter("department");
    String department_en = java.net.URLEncoder.encode(department, "UTF-8");

    String lectureNum = request.getParameter("lectureNum");

    String lectureName = request.getParameter("lectureName");

    String professor = request.getParameter("professor");
    String professor_en = java.net.URLEncoder.encode(professor, "UTF-8");

    String credit = request.getParameter("credit");
    String credit_en = java.net.URLEncoder.encode(credit, "UTF-8");

    String time = request.getParameter("time");
    String time_en = java.net.URLEncoder.encode(time, "UTF-8");

    String redirectUrl = "class.jsp?id=" + id + "&name=" + userName_en;

		String filePath = application.getRealPath("/WEB-INF/data/user/" + id);
		File f = new File(filePath);

		if (!f.exists()) {
			f.mkdir();
		}

		try {
			FileWriter fw = new FileWriter(filePath + "/bag", true);
			String lecture = "\n" + lectureNum + " " + lectureName + " " + professor + " " + credit + " " + time;
			fw.write(lecture);
			fw.close();
		} catch(FileNotFoundException e) {
			f.createNewFile();
			FileWriter fw = new FileWriter(filePath + "/bag");
			String lecture = lectureNum + " " + lectureName + " " + professor + " " + credit + " " + time;
			fw.write(lecture);
			fw.close();
		}
%>
<script>
  var lectureName = '<%= lectureName%>';
  var redirectUrl = '<%= redirectUrl%>';
  alert(lectureName + ' 강좌를 담았습니다!');
  location.href = redirectUrl;
</script>
