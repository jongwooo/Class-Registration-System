package command;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddClassCommand implements Command {

	public static String addAlert;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String campus = request.getParameter("campus");
		String college = request.getParameter("college");
		String department = request.getParameter("department");
		String lectureNum = request.getParameter("lectureNum");
		String lectureName = request.getParameter("lectureName");
		String professor = (String)request.getSession().getAttribute("name");
		String credit = request.getParameter("credit");
		String time = request.getParameter("time");
		String classPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/" + campus + "/" + college + "/" + department;

		try {
			boolean found = false;	
			if(lectureNum.equals("") || lectureName.equals("") || credit.equals("") || time.equals("")) {
				addAlert = "?status=form-failed&lecture=";
			} else if(campus.equals("캠퍼스 선택") || college.equals("분류 선택") || department.equals("분류 선택")) {
				addAlert = "?status=directory-failed&lecture=";
			} else {
				String newClass = lectureNum + " " + lectureName + " " + professor + " " + credit + " " + time;
				Scanner scanner = new Scanner(new File(classPath));

				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if(line.equals(newClass)) {
						found = true;
						break;
					}
				}
				if(!found){
					FileWriter fw = new FileWriter(classPath, true);
					fw.write(newClass  + "\n");
					fw.close();
					addAlert = "?status=addClassOK&lecture=" + lectureName;
				} else {
					addAlert = "?status=add-failed&lecture=" + lectureName;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

}
