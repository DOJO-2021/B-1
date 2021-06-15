package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDAO;
import dao.BbsReplyDAO;
import model.Reply;


/**
 * Servlet implementation class BbsDetailServlet
 */
@WebServlet("/BbsDetailServlet")
public class BbsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
					//	HttpSession session = request.getSession();
					//	if (session.getAttribute("user_id") == null) {
					//		response.sendRedirect("/B-1/LoginServlet");
					//		return;
					//	}
		//スレッド新規作成ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_deteil.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//リクエストスコープ
		request.setCharacterEncoding("UTF-8");
		int bbs_id =Integer.parseInt(request.getParameter("bbs_id"));
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		int reply_range =Integer.parseInt(request.getParameter("reply_range"));
		String reply_contents = request.getParameter("reply_contents");


		// コメントを行う
		BbsReplyDAO bDao = new BbsReplyDAO();
		BbsReplyDAO.insert(new Reply(0,user_id,user_name,reply_range,reply_contents));
		}
		// 掲示板トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_detail.jsp");
		dispatcher.forward(request, response);

	}


}
