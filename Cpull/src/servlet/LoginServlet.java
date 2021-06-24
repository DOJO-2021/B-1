package servlet;

import java.io.IOException;

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");

		// ログイン処理を行う
		UserDAO iDao = new UserDAO();
//		System.out.println(iDao.isLoginOK(id, pw));
		if (iDao.isLoginOK(id, pw)) {

			// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			LoginUser user = iDao.userselect(new LoginUser(id,0,""));
			user.setId(id);
			System.out.println("new1");
			session.setAttribute("user",user);


			/*// DAOから氏名、クラスを取り出す
			request.setCharacterEncoding("UTF-8");
			LoginUser Luser_id = (LoginUser) session.getAttribute("id");
			// セッションIDを変数u_idに代入
			String u_id = Luser_id.getId();
			// セッションIDと一致するリストの検索
			UserDAO sDao = new UserDAO();
			List<User> IDList = sDao.select(new User(u_id));
			// 検索結果をArrayListを使ってセッションスコープに格納する
			session.setAttribute("IDList", IDList);*/


//テスト成功
//		request.setCharacterEncoding("UTF-8");
//		LoginUser user_id = (LoginUser) session.getAttribute("id");
//		String user_id_id = user_id.getId();
//		System.out.println(user_id_id); //ちゃんと入ってるかコンソールで確認

		// セッションスコープにクラス(受講者orその他)を格納する
		// HttpSession session = request.getSession();
		// session.setAttribute("user_class", new LoginUser(user_class));

		// メニューサーブレットにリダイレクトする
		response.sendRedirect("/Cpull/MenuServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
					new Result("ログイン失敗！",  "/Cpull/LoginServlet", "ログインページへ"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/r_result.jsp");
			dispatcher.forward(request, response);
			}
		}
	}
