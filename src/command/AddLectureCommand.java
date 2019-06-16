package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static control.FrontControl.addMode;

public class AddLectureCommand implements Command {
	
	public static String addAlert;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String[] selectedLectures = request.getParameterValues("selectedLectures");
		if(selectedLectures != null) {
			final ArrayList<String> selectedLectureList = new ArrayList<String>(); 
			Collections.addAll(selectedLectureList, selectedLectures);

			String userID = (String)request.getSession().getAttribute("id");
			String addPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/user/" + userID;

			File file = new File(addPath);

			if (!file.exists()) {
				file.mkdir();
			}

			try {
				Scanner scanner = new Scanner(new File(addPath + "/" + addMode));
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					for(int i = 0;i < selectedLectureList.size();i++) {
						if(line.equals(selectedLectureList.get(i))) {
							selectedLectureList.remove(i);
						}
					}
				}

				if(selectedLectureList.size() > 0) {
					FileWriter fw = new FileWriter(file + "/" + addMode, true);
					for(int j = 0; j < selectedLectureList.size();j++) {
						fw.write(selectedLectureList.get(j) + "\n");
					}
					fw.close();
				}
			} catch (FileNotFoundException e) {
				try {
					FileWriter fw = new FileWriter(file + "/" + addMode);
					for(int i = 0; i < selectedLectureList.size();i++) {
						fw.write(selectedLectureList.get(i) + "\n");
					}
					fw.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}
			} catch (IOException e) {

			}
			
			addAlert = "?status=" + addMode + "&count=" + selectedLectureList.size();
		}
	}
}
