package command;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLecture;
import entity.ELecture;

public class LectureCommand implements Command {

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
			request.setAttribute("lectures", items);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}

}
