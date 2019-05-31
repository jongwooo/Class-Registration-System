<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
  <%
    request.setCharacterEncoding("utf-8");
    String id  = request.getParameter("id");

    String userName  = request.getParameter("name");
    String userName_en = java.net.URLEncoder.encode(userName, "UTF-8");

    String department  = request.getParameter("department");
    String department_en = java.net.URLEncoder.encode(department, "UTF-8");

    String lectureNum = request.getParameter("lectureNum");
    String lectureNum_en = java.net.URLEncoder.encode(lectureNum, "UTF-8");

    String lectureName = request.getParameter("lectureName");
    String lectureName_en = java.net.URLEncoder.encode(lectureName, "UTF-8");

    String lectureCredit  = request.getParameter("lectureCredit");
    String lectureCredit_en = java.net.URLEncoder.encode(lectureCredit, "UTF-8");

    String lectureTime  = request.getParameter("lectureTime");
    String lectureTime_en = java.net.URLEncoder.encode(lectureTime, "UTF-8");

    String redirectUrl = "professor.jsp?id=" + id + "&name=" + userName_en + "&department=" + department_en + "&lectureNum=" + lectureNum_en + "&lectureName=" + lectureName_en + "&lectureCredit=" + lectureCredit_en + "&lectureTime=" + lectureTime_en;
    response.sendRedirect(redirectUrl);
%>
