package command;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLecture;
import entity.ELecture;

public class MySincheongCommand implements Command {
	
	public static String viewPage;
	public static String sincheongPath;
	private DAOLecture dAOMySincheong;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.dAOMySincheong = new DAOLecture();
		String userID = (String)request.getSession().getAttribute("id");
		sincheongPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/user/" + userID + "/sincheong";
		
		try {
			Vector<ELecture> items;
			items = this.dAOMySincheong.getItems();
			request.setAttribute("sincheong", items);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
	}
}