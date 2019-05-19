<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
    String[] userId = {"h", "k", "l"};
    String[] password = {"1", "2", "3"};

    String id = request.getParameter("userId");
    String pw = request.getParameter("password");

    String redirectUrl = "login.jsp?error=login-failed";
    for (int i = 0; i < userId.length; i++) {
        if (userId[i].equals(id) && password[i].equals(pw))
            redirectUrl = "class.jsp?id=" + id;
    }
    response.sendRedirect(redirectUrl);
%>
