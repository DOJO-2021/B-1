package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//コメントアウト外すとServed at / Cpull画面が出てくるので一旦保留↓
		//まだログイン画面?Servletができていないから、全部ページができたらできるはず？

//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/Cpull/LoginServlet");
//			return;
//	}

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
	}

}



		//メニューからそれぞれのボタンを押したときは、フォワードじゃなくてリダイレクトする？
		//フォワード後⇒URLはリクエスト時のまま  リダイレクト⇒リダイレクト先のURLに変更

//
//		//自己紹介をクリックしたら、自己紹介トップページにフォワードする
//			RequestDispatcher dispatcher_profile =
//					request.getRequestDispatcher("/WEB-INF/jsp/forwardSample.jsp");
//			dispatcher_profile.forward(request, response);
//		//トークルームをクリックしたら、トークルームトップページにフォワードする
//			RequestDispatcher dispatcher_talk =
//					request.getRequestDispatcher("/WEB-INF/jsp/forwardSample.jsp");
//			dispatcher_talk.forward(request, response);
//		//掲示板をクリックしたら、掲示板トップページにフォワードする
//			RequestDispatcher dispatcher_bbs =
//					request.getRequestDispatcher("/WEB-INF/jsp/forwardSample.jsp");
//			dispatcher_bbs.forward(request, response);
//		//マイページをクリックしたら、マイページにフォワードする
//			RequestDispatcher dispatcher_mypage =
//					request.getRequestDispatcher("/WEB-INF/jsp/forwardSample.jsp");
//			dispatcher_mypage.forward(request, response);
//		//お問い合わせをクリックしたら、お問い合わせページにフォワードする
//			RequestDispatcher dispatcher_inquiry =
//					request.getRequestDispatcher("/WEB-INF/jsp/forwardSample.jsp");
//			dispatcher_inquiry.forward(request, response);
//		//ログアウトをクリックしたら、ログインページにフォワードする
//			RequestDispatcher dispatcher_logout =
//					request.getRequestDispatcher("/WEB-INF/jsp/forwardSample.jsp");
//			dispatcher_logout.forward(request, response);


