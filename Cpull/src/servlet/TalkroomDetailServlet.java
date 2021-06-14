package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TalkroomDetailServlet
 */
@WebServlet("/TalkroomDetailServlet")
public class TalkroomDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// どのトークルームを選択するか　条件分岐
		//BcDAO bDao = new BcDAO();
		if (request.getParameter("submit").equals("1")) { //valueのところと一致していれば
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk_detail1.jsp");
			dispatcher.forward(request, response);
		}
		else if(request.getParameter("submit").equals("2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk_detail2.jsp");
			dispatcher.forward(request, response);
		}
		else if(request.getParameter("submit").equals("3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk_detail3.jsp");
			dispatcher.forward(request, response);
		}
	}
}
