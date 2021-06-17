package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.Result;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("USER_ID");
		String user_name = request.getParameter("USER_NAME");
		String user_pw = request.getParameter("USER_PW");
		String user_k_name = request.getParameter("USER_K_NAME");
		String user_company = request.getParameter("USER_COMPANY");
		int user_class = Integer.parseInt(request.getParameter("USER_CLASS"));
		 /*
		String user_prefecture = request.getParameter("USER_PREFECTURE");
		String user_hobby = request.getParameter("USER_HOBBY");
		String user_skill = request.getParameter("USER_SKILL");
		String user_birth = request.getParameter("USER_BIRTH");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		fmt.parse(user_birth);
		String user_remarks = request.getParameter("USER_REMARKS");
		int user_range = Integer.parseInt(request.getParameter("USER_RANGE")); //区分はどのように数値取ってくる？
		String user_image = request.getParameter("USER_IMAGE");
		*/

		// PWチェック入れる(java p.568参照)
		// 登録処理を行う
		UserDAO uDao = new UserDAO();
		if (request.getParameter("REGIST").equals("登録")) {
			if (uDao.insert(new User(user_id, user_name, user_pw, user_k_name, user_company, user_class, null, null, null, null, null, 0, null))) {
			// 登録成功
			request.setAttribute("result",
			new Result("登録に成功しました。",  "/Cpull/LoginServlet"));
			}
			else {
			// 登録失敗
			request.setAttribute("result",
			new Result("登録に失敗しました！", "/Cpull/LoginServlet"));
			}
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/r_result.jsp");
		dispatcher.forward(request, response);
	}

}
