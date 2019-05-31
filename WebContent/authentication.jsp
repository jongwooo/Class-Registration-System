<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.Scanner"%>


<%
	String id = request.getParameter("userId");
	String pw = request.getParameter("password");

	String redirectUrl = "login.jsp?error=login-failed";

	try {
		String loginPath = application.getRealPath("/WEB-INF/data/login");
		Scanner scanner = new Scanner(new File(loginPath));

		while (scanner.hasNext()) {
			String userID = scanner.next();
			String userPW = scanner.next();
			String userType = scanner.next();
			String userName = scanner.next();
			String userName_en = java.net.URLEncoder.encode(userName, "UTF-8");

			if (userID.equals(id) && userPW.equals(pw)) {
				if (userType.equals("s")) {
					redirectUrl = "class.jsp?id=" + id + "&name=" + userName_en;
					scanner.close();
					break;
				} else if (userType.equals("p"))
					redirectUrl = "professor.jsp?id=" + id + "&name=" + userName_en;
				scanner.close();
				break;
			}
		}
	} catch (FileNotFoundException e) {

	}

	response.sendRedirect(redirectUrl);
%>
