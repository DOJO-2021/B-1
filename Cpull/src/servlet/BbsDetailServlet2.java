package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsReplyDAO;
import model.Reply;

/**
 * Servlet implementation class BbsDetailServlet2
 */
@WebServlet("/BbsDetailServlet2")
public class BbsDetailServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストスコープ
		request.setCharacterEncoding("UTF-8");

		String bbs_id_string = request.getParameter("bbs_id");
		int bbs_id = Integer.parseInt(bbs_id_string);
		//		LoginUser user_id_id = (LoginUser) session.getAttribute("id");
		//		String user_id = user_id_id.getId();
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String reply_range_string = request.getParameter("reply_range");
		int reply_range = Integer.parseInt(reply_range_string);
		String reply_contents = request.getParameter("reply_contents");

		//System.out.println(bbs_id);
		//System.out.println(user_id);
		//System.out.println(user_name);
		//System.out.println(reply_range);
		//System.out.println(reply_contents);
		// コメントを行う
		BbsReplyDAO bDao = new BbsReplyDAO();
		bDao.insert(new Reply(0, user_id, user_name, reply_range, reply_contents));

		// detailページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
		dispatcher.forward(request, response);

	}

}
