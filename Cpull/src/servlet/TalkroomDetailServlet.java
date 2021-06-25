package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginUser;

/**
 * Servlet implementation class TalkroomDetailServlet
 */
@WebServlet("/TalkroomDetailServlet")
public class TalkroomDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("user");
		if (user.getId() == null) {
			response.sendRedirect("/Cpull/LoginServlet");
		return;
		}

		// どのトークルームを選択するか　条件分岐　⇒例外になってしまう
		//リクエストパラメーターを取得する
		request.setCharacterEncoding("UTF-8");
		String roomNum = request.getParameter("room");

		if(roomNum.equals("1")) {//valueの値（１～３）が一致していれば各jspへフォワードさせる
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk_detail1.jsp");
			dispatcher.forward(request, response);
		}
		else if(roomNum.equals("2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk_detail2.jsp");
			dispatcher.forward(request, response);
		}
		else if(roomNum.equals("3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/talk_detail3.jsp");
			dispatcher.forward(request, response);
		}


	}
}