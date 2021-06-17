package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDAO;
import model.User;

/**
 * Servlet implementation class ProfileListServlet
 */
@WebServlet("/ProfileListServlet")
public class ProfileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Cpull/LoginServlet");
			return;
		}

		// 検索処理を行う
		ProfileDAO bDao = new ProfileDAO();
		List<User> cardList = bDao.select(new User("", "", "", "", "", 0, "", "", "", "", "", 0, ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile_list.jsp");
		dispatcher.forward(request, response);

		/*	*//**
				* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
				*//*
					protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					// TODO Auto-generated method stub
					doGet(request, response);
					}*/

	}
}
