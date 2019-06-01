<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.Scanner"%>
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

	String lectureName = request.getParameter("lectureName");

	String lineNum = request.getParameter("lineNum");

	int countLine = Integer.parseInt(lineNum);

	String redirectUrl = "professor.jsp?id=" + id + "&name=" + userName_en + "&campus=" + campus_en + "&college=" + college_en + "&department=" + department_en;

	try {
		String filePath = application.getRealPath("/WEB-INF/data/" + campus + "/" + college) + "/" + department;
		File file = new File(filePath);
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);

		String dummy = "";
		String line;

		for (int i = 1; i < countLine; i++) {
			line = br.readLine();
			dummy += (line + "\n");
		}

		br.readLine();

		while ((line = br.readLine()) != null) {
			dummy += (line + "\n");
		}

		FileWriter fw = new FileWriter(filePath);
		fw.write(dummy);

		fw.close();
		br.close();
	} catch (FileNotFoundException e) {

	}
%>
<script>
  var lectureName = '<%= lectureName%>';
  var redirectUrl = '<%= redirectUrl%>';
  alert(lectureName + ' 강좌를 삭제했습니다!');
  location.href = redirectUrl;
</script>
