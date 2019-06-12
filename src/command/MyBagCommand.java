package command;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOLecture;
import entity.ELecture;

public class MyBagCommand implements Command {

	public static String viewPage;
	public static String basketPath;
	private DAOLecture dAOMyBag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.dAOMyBag = new DAOLecture();
		String userID = (String)request.getSession().getAttribute("id");
		basketPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/user/" + userID + "/bag";
		
		try {
			Vector<ELecture> items;
			items = this.dAOMyBag.getItems();
			request.setAttribute("myBag", items);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block	
		}
	}
}

