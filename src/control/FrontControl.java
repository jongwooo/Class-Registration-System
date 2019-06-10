package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.LectureCommand;
import command.Command;
import command.LoginCommand;
import command.LogoutCommand;
import command.MyBagCommand;
import command.MySincheongCommand;


/**
 * Servlet implementation class FrontControl
 */
@WebServlet("*.do")
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String lectureMode;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		Command command = null;
		lectureMode = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/index.do")) {
			viewPage = "/index.jsp";
		} else if(com.equals("/login.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage = LoginCommand.viewPage;
		} else if(com.equals("/logout.do")) {
			command = new LogoutCommand();
			command.execute(request, response);
			viewPage = "/index.jsp";
		} else if(com.equals("/class.do")) {
			viewPage = "/class.jsp";
		} else if(com.equals("/lecture.do")) {
			lectureMode = "lecture";
			command = new LectureCommand();
			command.execute(request, response);
			viewPage = LectureCommand.viewPage;
		} else if(com.equals("/myBag.do")) {
			lectureMode = "myBag";
			command = new MyBagCommand();
			command.execute(request, response);
			lectureMode = "sincheong";
			command = new MySincheongCommand();
			command.execute(request, response);
			viewPage = MyBagCommand.viewPage + MySincheongCommand.viewPage;
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
