package command;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLogin;
import entity.ELogin;

public class RegisterCommand implements Command {
	
	public static String viewPage;
	private DAOLogin dAORegister;
	public static String rootPath;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.dAORegister = new DAOLogin();
		rootPath = request.getSession().getServletContext().getRealPath("/");
		String registerPath = rootPath + "WEB-INF/data/user";
		String registerID = request.getParameter("registerID");
		String registerPW = request.getParameter("registerPW");
		String confirmPW = request.getParameter("confirmPW");
		String registerName = request.getParameter("registerName");
		int index = 0;
		boolean exist = false;
		
		try {
			Vector<ELogin> items;
			items = this.dAORegister.getItems();
			for(index = 0;index < items.size();index++) {
				if(items.get(index).getUserID().equals(registerID)) {
					exist = true;
				}
			}
			if(registerID.equals("") || registerPW.equals("") || confirmPW.equals("") || registerName.equals("")) {
				viewPage = "register.jsp?error=register-failed";
			} else if(exist) {
				viewPage = "register.jsp?error=exist-failed";
			} else if(!(registerPW.equals(confirmPW))) {
				viewPage = "register.jsp?error=password-failed";
			} else {
				FileWriter fw = new FileWriter(registerPath + "/login", true);
				fw.write(registerID + " " + registerPW + " " + registerName + "\n");
				fw.close();
				viewPage = "index.jsp?status=registerOK";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

}
