package command;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLogin;
import entity.ELogin;

public class LoginCommand implements Command {

	public static String viewPage;
	private DAOLogin dAOLogin;
	public static String rootPath;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.dAOLogin = new DAOLogin();

		rootPath = request.getSession().getServletContext().getRealPath("/");
		try {
			Vector<ELogin> items;
			items = this.dAOLogin.getItems();
			String id = request.getParameter("userId");
			String pw = request.getParameter("password");
			viewPage = "index.jsp?error=login-failed";
			int index = 0;
			boolean found = false;
			for(index = 0;index < items.size() && !found;index++) {
				if (items.get(index).getUserID().equals(id) && items.get(index).getUserPW().equals(pw)) {
					found = true;
					request.getSession().setAttribute("id", items.get(index).getUserID());
					request.getSession().setAttribute("name", items.get(index).getUserName());
					viewPage = "/class.jsp";
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}
}
