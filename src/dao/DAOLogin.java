package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELogin;
import static command.LoginCommand.loginPath;
import static command.RegisterCommand.rootPath;
import static command.IForgotCommand.iForgotPath;
import static control.FrontControl.userMode;

public class DAOLogin {
	
	public Vector<ELogin> getItems() throws FileNotFoundException {
		Vector<ELogin> eItems = new Vector<ELogin>();
		String userPath = null;
		if(userMode.equals("login")) {
			userPath = loginPath;
		} else if(userMode.equals("register")) {
			userPath = rootPath;
		} else if(userMode.equals("iforgot")) {
			userPath = iForgotPath;
		}
		Scanner scanner = new Scanner(new File(userPath + "WEB-INF/data/user/login"));
	
		while(scanner.hasNext()) {
			ELogin eItem = new ELogin();
			eItem.read(scanner);
			eItems.add(eItem);
		}

		scanner.close();
		return eItems;
	}
}