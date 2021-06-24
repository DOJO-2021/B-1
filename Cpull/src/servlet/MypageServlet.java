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

import dao.UserDAO;
import model.LoginUser;
import model.Result;
import model.User;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
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

		//セッションスコープのidをキーにm_userテーブルからデータを取得するdaoを作成
		//セッションidを変数u_idに代入
		// String u_id = session.getAttribute("id").toString();
		request.setCharacterEncoding("UTF-8");
		LoginUser Luser_id = (LoginUser) session.getAttribute("user");
		String u_id = Luser_id.getId();
		//userモデルを作成（u_id,"",,,,)
		// User user = new User(user_id);
		// new user(u_id)
		//上のモデルでdaoのセレクト分を実行して、lisｔ方の変数に代入
		// セッションIDと一致するリストの検索
		UserDAO sDao = new UserDAO();
		List<User> cardList = sDao.select(new User(u_id));
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
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


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String user_name = request.getParameter("USER_NAME");
		String user_pw = request.getParameter("USER_PW");
		String user_k_name = request.getParameter("USER_K_NAME");
		String user_company = request.getParameter("USER_COMPANY");
		int user_class = Integer.parseInt(request.getParameter("USER_CLASS"));
		String user_prefecture = request.getParameter("USER_PREFECTURE");
		String user_hobby = request.getParameter("USER_HOBBY");
		String user_skill = request.getParameter("USER_SKILL");
		String user_birth = request.getParameter("USER_BIRTH");
		String user_remarks = request.getParameter("USER_REMARKS");
		int user_range = Integer.parseInt(request.getParameter("USER_RANGE"));
		String user_image = request.getParameter("USER_IMAGE");


		// 更新を行う
		UserDAO uDao = new UserDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (uDao.update(new User(user_id, user_name, user_pw, user_k_name, user_company, user_class, user_prefecture, user_hobby, user_skill, user_birth, user_remarks, user_range, user_image))) {
				// 更新成功
				request.setAttribute("result",
				new Result("更新に成功しました。", "/Cpull/MenuServlet", "メニューへ"));
			}
			else {
				// 更新失敗
				request.setAttribute("result",
				new Result("更新に失敗しました。", "/Cpull/MenuServlet", "メニューへ"));
			}
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/r_result.jsp");
		dispatcher.forward(request, response);
	}

}
