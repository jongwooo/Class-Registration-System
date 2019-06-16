package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveClassCommand implements Command {

	public static String removeAlert;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String campus = request.getParameter("campus");
		String college = request.getParameter("college");
		String department = request.getParameter("department");
		String[] selectedLectures = request.getParameterValues("selectedLectures");
		if(selectedLectures != null) {
			String removePath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/" + campus + "/" + college + "/" + department;
			ArrayList<String> lectureList = new ArrayList<String>();
			try {
				File file = new File(removePath);
				Scanner scanner = new Scanner(file);

				while (scanner.hasNextLine()) {
					boolean found = false;
					String line = scanner.nextLine();
					for(int i = 0;i < selectedLectures.length;i++) {
						if(line.equals(selectedLectures[i])) {
							found = true;
							break;
						}
					}
					if(!found) {
						lectureList.add(line);
					}
				}
				
				FileWriter fw = new FileWriter(file);
				for(int i = 0; i < lectureList.size();i++) {
					fw.write(lectureList.get(i) + "\n");
				}
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
	}

}
