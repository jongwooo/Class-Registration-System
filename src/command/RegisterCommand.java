package command;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
	
	public static String viewPage;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String registerPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/user";
		try {
			String registerID = request.getParameter("registerID");
			String registerPW = request.getParameter("registerPW");
			String confirmPW = request.getParameter("confirmPW");
			String registerName = request.getParameter("registerName");
			if(registerID.equals("") || registerPW.equals("") || confirmPW.equals("") || registerName.equals("")) {
				viewPage = "register.jsp?error=register-failed";
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
