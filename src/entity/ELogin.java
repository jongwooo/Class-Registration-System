package entity;
import java.util.Scanner;

public class ELogin {
	private String userID;
	private String userPW;
	private String userName;
	
	public void read(Scanner scanner) {
		userID = scanner.next();
		userPW = scanner.next();
		userName = scanner.next();
	}

	public String getUserID() {
		return userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public String getUserName() {
		return userName;
	}
	
}