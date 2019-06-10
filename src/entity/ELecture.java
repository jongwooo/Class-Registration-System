package entity;
import java.util.Scanner;

public class ELecture {
	private String lectureNum;
	private String lectureName;
	private String professor;
	private String credit;
	private String time;

	public void read(Scanner scanner) {
		lectureNum = scanner.next();
		lectureName = scanner.next();
		professor = scanner.next();
		credit = scanner.next();
		time = scanner.next();
	}

	public String getLectureNum() {
		return lectureNum;
	}

	public String getLectureName() {
		return lectureName;
	}

	public String getProfessor() {
		return professor;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}
}	
