package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InquiryDAO;
import model.Inquiry;

/**
 * Servlet implementation class InquiryServlet
 */
@WebServlet("/InquiryServlet")
public class InquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//ログインの部分は後でコメントアウトを外す
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/Cpull/LoginServlet");
					return;
				}

		// お問い合わせページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inquiry.jsp");
		dispatcher.forward(request, response);
	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
				protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// もしもログインしていなかったらログインサーブレットにリダイレクトする
				//ログインの部分は後でコメントアウトを外す

				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/Cpull/LoginServlet");
					return;
				}

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = session.getAttribute("id").toString();
				String subject= request.getParameter("SUBJECT");
				String message= request.getParameter("MESSAGE");
				System.out.println(user_id); //ちゃんと入ってるかコンソールで確認
				// 登録処理を行う
				InquiryDAO iDao = new InquiryDAO();
				iDao.insert(new Inquiry(user_id, 0, subject, message, null)); //ユーザーID,お問い合わせID,件名,内容,お問い合わせ時刻

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/i_result.jsp");
				dispatcher.forward(request, response);
				}
}