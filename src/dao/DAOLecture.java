package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELecture;
import static control.FrontControl.lectureMode;
import static command.LectureCommand.lecturePath;
import static command.MyBagCommand.basketPath;
import static command.MySincheongCommand.sincheongPath;

public class DAOLecture {
	
	public Vector<ELecture> getItems() throws FileNotFoundException {
		Vector<ELecture> eItems = new Vector<ELecture>();
		String realPath = null;
		
		if(lectureMode == "lecture") {
			realPath = lecturePath;
		} else if(lectureMode == "myBag") {
			realPath = basketPath;
		} else if(lectureMode == "sincheong") {
			realPath = sincheongPath;
		}
		
		Scanner scanner = new Scanner(new File(realPath));
	
		while(scanner.hasNext()) {
			ELecture eItem = new ELecture();
			eItem.read(scanner);
			eItems.add(eItem);
		}

		scanner.close();
		return eItems;
	}
}