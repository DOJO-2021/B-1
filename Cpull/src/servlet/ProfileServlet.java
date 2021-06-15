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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
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

		// 自己紹介トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile_top.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Cpull/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する 直すところ　profile_topのデータ
				request.setCharacterEncoding("UTF-8");
				String user_name = request.getParameter("USER_NAME");
				String user_company = request.getParameter("USER_COMPANY");
				String user_prefecture = request.getParameter("USER_PREFECTURE");
				String user_hobby = request.getParameter("USER_HOBBY");
				String user_skill = request.getParameter("USER_SKILL");
				Date user_birth = request.getParameter("USER_BIRTH");
				String user_remarks = request.getParameter("USER_REMARKS");


		// 検索処理を行う
		ProfileDAO bDao = new ProfileDAO();
		List<User> cardList = bDao.select(new User(0, user_name, user_company, user_prefecture, user_hobby , user_skill, user_birth, user_remarks));


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile_list.jsp");
		dispatcher.forward(request, response);
	}
}