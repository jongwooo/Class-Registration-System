<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
  <%
    request.setCharacterEncoding("utf-8");
    String id  = request.getParameter("id");
    String department  = request.getParameter("department");
    String department_en = java.net.URLEncoder.encode(department, "UTF-8");

    String redirectUrl = "class.jsp?id=" + id + "&department=" + department_en;
    response.sendRedirect(redirectUrl);
%>
