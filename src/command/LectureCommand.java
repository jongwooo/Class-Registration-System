package command;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLecture;
import entity.ELecture;

public class LectureCommand implements Command {

	public static String viewPage;
	public static String lecturePath;
	private DAOLecture dAOLecture;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.dAOLecture = new DAOLecture();
		
		String campus = request.getParameter("campus");
		String college = request.getParameter("college");
		String department = request.getParameter("department");
		lecturePath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/" + campus + "/" + college + "/" + department;
		
		try {
			Vector<ELecture> items;
			items = this.dAOLecture.getItems();
			String lectureTable = "";
			int index;
			
			for(index = 0;index < items.size();index++) {
				String selectedLecture = items.get(index).getLectureNum() + " " + items.get(index).getLectureName() + " " 
			+ items.get(index).getProfessor() + " " + items.get(index).getCredit() + " " + items.get(index).getTime();
				lectureTable += "<tr>\n" +
						"  <td><input type=\'checkbox\' name=\'selectedLectures\' value=\'" + selectedLecture + "\'></td>\n" +
						"  <td>" + items.get(index).getLectureNum() + "</td>\n" +
						"  <td>" + items.get(index).getLectureName() + "</td>\n" +
						"  <td>" + items.get(index).getProfessor() + "</td>\n" +
						"  <td>" + items.get(index).getCredit() + "</td>\n" +
						"  <td>" + items.get(index).getTime() + "</td>\n" +
						"</tr>";
			}
			viewPage = "/class.jsp?lectureTable=" + lectureTable;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			viewPage = "/class.jsp";
		}
	}

}
