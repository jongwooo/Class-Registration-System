package command;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLogin;
import entity.ELogin;

public class IForgotCommand implements Command {

	public static String viewPage;
	private DAOLogin dAOIForgot;
	public static String iForgotPath;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.dAOIForgot = new DAOLogin();
		iForgotPath = request.getSession().getServletContext().getRealPath("/");
		String iforgotID = request.getParameter("iforgotID");
		String iforgotName = request.getParameter("iforgotName");

		boolean ifound = false;
		String iforgotPW = "";

		try {
			Vector<ELogin> items;
			items = this.dAOIForgot.getItems();
			for(int index = 0;index < items.size();index++) {
				if(items.get(index).getUserID().equals(iforgotID) && items.get(index).getUserName().equals(iforgotName)) {
					ifound = true;
					iforgotPW = items.get(index).getUserPW();
					break;
				}
			}
			if(iforgotID.equals("") || iforgotName.equals("")) {
				viewPage = "iforgot.jsp?status=form-failed";
			} else if(ifound) {
				request.setAttribute("iforgotPW", iforgotPW);
				viewPage = "iforgot.jsp?status=ifound";
			} else {
				viewPage = "iforgot.jsp?status=mismatch-failed";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} 
	}
}
