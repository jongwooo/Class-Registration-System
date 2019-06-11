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
			int index;
			String basketTable = "";
			
			for(index = 0;index < items.size();index++) {
				String selectedLecture = items.get(index).getLectureNum() + " " + items.get(index).getLectureName() + " " 
					+ items.get(index).getProfessor() + " " + items.get(index).getCredit() + " " + items.get(index).getTime();
				basketTable += "<tr>\n" +
						"  <td><input type=\'checkbox\' name=\'selectedLectures\' value=\'" + selectedLecture + "\'></td>\n" +
						"  <td>" + items.get(index).getLectureNum() + "</td>\n" +
						"  <td>" + items.get(index).getLectureName() + "</td>\n" +
						"  <td>" + items.get(index).getProfessor() + "</td>\n" +
						"  <td>" + items.get(index).getCredit() + "</td>\n" +
						"  <td>" + items.get(index).getTime() + "</td>\n" +
						"</tr>\n";
			}
			viewPage = "/myBag.jsp?basketTable=" + basketTable;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			viewPage = "/myBag.jsp?basketTable=";
		}
	}

}

