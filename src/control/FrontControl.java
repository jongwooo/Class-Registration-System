package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.LectureCommand;
import command.AddLectureCommand;
import command.Command;
import command.LoginCommand;
import command.LogoutCommand;
import command.MyBagCommand;
import command.MySincheongCommand;
import command.RegisterCommand;
import command.RemoveLectureCommand;


/**
 * Servlet implementation class FrontControl
 */
@WebServlet("*.do")
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String lectureMode;
	public static String addMode;
	public static String removeMode;
	public static String userMode;
       
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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/index.do")) {
			viewPage = "/index.jsp";
		} else if(com.equals("/register.do")) {
			userMode = "register";
			command = new RegisterCommand();
			command.execute(request, response);
			viewPage = RegisterCommand.viewPage;
		} else if(com.equals("/login.do")) {
			userMode = "login";
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
			viewPage = "/class.jsp";
		} else if(com.equals("/myBag.do")) {
			lectureMode = "myBag";
			command = new MyBagCommand();
			command.execute(request, response);
			lectureMode = "sincheong";
			command = new MySincheongCommand();
			command.execute(request, response);
			viewPage = "/myBag.jsp";
		} else if(com.equals("/addBag.do")) {
			addMode = "bag";
			command = new AddLectureCommand();
			command.execute(request, response);
			viewPage = "/class.jsp";
		} else if(com.equals("/addSincheong.do")) {
			addMode = "sincheong";
			command = new AddLectureCommand();
			command.execute(request, response);
			viewPage = "/class.jsp";
		} else if(com.equals("/addMySincheong.do")) {
			addMode = "sincheong";
			command = new AddLectureCommand();
			command.execute(request, response);
			removeMode = "bag";
			command = new RemoveLectureCommand();
			command.execute(request, response);
			viewPage = "/myBag.do";
		} else if(com.equals("/removeBag.do")) {
			removeMode = "bag";
			command = new RemoveLectureCommand();
			command.execute(request, response);
			viewPage = "/myBag.do";
		} else if(com.equals("/removeSincheong.do")) {
			removeMode = "sincheong";
			command = new RemoveLectureCommand();
			command.execute(request, response);
			addMode = "bag";
			command = new AddLectureCommand();
			command.execute(request, response);
			viewPage = "/myBag.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
