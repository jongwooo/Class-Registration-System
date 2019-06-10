package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static control.FrontControl.addMode;

public class AddLectureCommand implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String[] selectedLectures = request.getParameterValues("selectedLectures");
		String userID = (String)request.getSession().getAttribute("id");
		String basketPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF/data/user/" + userID;
		
		File f = new File(basketPath);
		
		if (!f.exists()) {
			f.mkdir();
		}
		
		try {
			FileWriter fw = new FileWriter(f + "/" + addMode, true);
			for(int i = 0; i < selectedLectures.length;i++) {
				fw.write(selectedLectures[i] + "\n");
			}
			fw.close();
		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter(f + "/" + addMode);
				for(int i = 0; i < selectedLectures.length;i++) {
					fw.write(selectedLectures[i] + "\n");
				}
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
			}
		} catch (IOException e) {
			
		}
	}
}
