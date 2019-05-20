<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
    String[] studentID = {"h", "k", "l"};
    String[] studentPW = {"1", "2", "3"};

    String[] professorID = {"choi", "kim", "lee"};
    String[] professorPW = {"1", "2", "3"};

    String id = request.getParameter("userId");
    String pw = request.getParameter("password");

    String redirectUrl = "login.jsp?error=login-failed";
    for (int i = 0; i < studentID.length; i++) {
        if (studentID[i].equals(id) && studentPW[i].equals(pw))
            redirectUrl = "class.jsp?id=" + id;
    }

    for (int j = 0; j < professorID.length; j++) {
        if (professorID[j].equals(id) && professorPW[j].equals(pw))
            redirectUrl = "professor.jsp?id=" + id;
    }
    response.sendRedirect(redirectUrl);
%>
