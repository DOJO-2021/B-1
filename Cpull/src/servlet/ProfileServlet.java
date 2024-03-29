package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDAO;
import model.LoginUser;
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
		LoginUser user = (LoginUser) session.getAttribute("user");
		if (user.getId() == null) {
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
		LoginUser user = (LoginUser) session.getAttribute("user");
		if (user.getId() == null) {
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
				String user_birth = request.getParameter("USER_BIRTH");
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
				/*try {
					Date date = sdFormat.parse(user_birth);
				} catch (ParseException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}*/

				String user_remarks = request.getParameter("USER_REMARKS");


		// 検索処理を行う
		ProfileDAO bDao = new ProfileDAO();
		List<User> cardList = bDao.select(new User("", user_name,"","", user_company,0, user_prefecture, user_hobby , user_skill, user_birth, user_remarks,0,""));

		ProfileDAO bbDao = new ProfileDAO();
		List<User> cardList_name = bbDao.select_name(new User("", user_name,"","", user_company,0, user_prefecture, user_hobby , user_skill, user_birth, user_remarks,0,""));

		ProfileDAO bbbDao = new ProfileDAO();
		List<User> cardList_birthday = bbbDao.select_birthday(new User("", user_name,"","", user_company,0, user_prefecture, user_hobby , user_skill, user_birth, user_remarks,0,""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		request.setAttribute("cardList_name", cardList_name);
		request.setAttribute("cardList_birthday", cardList_birthday);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile_list.jsp");
		dispatcher.forward(request, response);
	}
}