package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELogin;
import static command.LoginCommand.rootPath;

public class DAOLogin {
	
	public Vector<ELogin> getItems() throws FileNotFoundException {
		Vector<ELogin> eItems = new Vector<ELogin>();
		Scanner scanner = new Scanner(new File(rootPath + "WEB-INF/data/user/login"));
	
		while(scanner.hasNext()) {
			ELogin eItem = new ELogin();
			eItem.read(scanner);
			eItems.add(eItem);
		}

		scanner.close();
		return eItems;
	}
}