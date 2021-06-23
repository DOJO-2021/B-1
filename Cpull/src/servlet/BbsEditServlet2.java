package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDAO;
import dao.BbsDraftDAO;
import model.BBS;
import model.Draft;

/**
 * Servlet implementation class BbsEditServlet2
 */
@WebServlet("/BbsEditServlet2")
public class BbsEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//		HttpSession session = request.getSession();
		//			if (session.getAttribute("id") == null) {
		//				response.sendRedirect("/B-1/LoginUserServlet");
		//		return;
		//		}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//				LoginUser user_id_id = (LoginUser) session.getAttribute("id");
		//				String user_id = user_id_id.getId();
		String user_id = request.getParameter("user_id");
		String bbs_id_string = request.getParameter("bbs_id");
		int bbs_id = Integer.parseInt(bbs_id_string);
		String bbs_title = request.getParameter("bbs_title");
		String bbs_details = request.getParameter("bbs_details");
		String bbs_pw = request.getParameter("bbs_pw");
		String bbs_range_string = request.getParameter("bbs_range");
		int bbs_range = Integer.parseInt(bbs_range_string);
		//int bbs_range= Integer.parseInt(request.getParameter("bbs_range"));
		String bbs_category_string = request.getParameter("bbs_category");
		int bbs_category = Integer.parseInt(bbs_category_string);

		//int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));

		System.out.println(bbs_id);

		// 更新または削除を行う
		BbsDAO bDao = new BbsDAO();
		BbsDraftDAO brDao = new BbsDraftDAO();
		if (request.getParameter("submit").equals("更新")) {

			bDao.update(new BBS(user_id, 0, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category));// 更新成功
		} else if (request.getParameter("submit").equals("削除")) {
			bDao.delete(bbs_id); // 削除成功

		} else if (request.getParameter("submit").equals("下書き保存")) {
			brDao.insert(new Draft(user_id, 0, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category));
		}
		// 掲示板トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
		dispatcher.forward(request, response);
	}

}
