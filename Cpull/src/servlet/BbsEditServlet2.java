package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BbsDAO;
import model.BBS;
import model.LoginUser;

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
				HttpSession session = request.getSession();
				LoginUser user = (LoginUser) session.getAttribute("user");

				if (user.getId() == null) {
					response.sendRedirect("/Cpull/LoginServlet");
					return;
				}

//					if (session.getAttribute("id") == null) {
//						response.sendRedirect("/B-1/LoginUserServlet");
//				return;
//				}
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
//		LoginUser user_id_id = (LoginUser) session.getAttribute("user");
		String user_id = user.getId();
		//String user_id = request.getParameter("user_id");
		String bbs_id_string = request.getParameter("bbs_id");
		int bbs_id = Integer.parseInt(bbs_id_string);
		String bbs_title = request.getParameter("bbs_title");
		String bbs_details = request.getParameter("bbs_details");
		String bbs_pw = request.getParameter("bbs_pw");
		String bbs_range_string = request.getParameter("bbs_range");
		int bbs_range = Integer.parseInt(bbs_range_string);
		//int bbs_range= Integer.parseInt(request.getParameter("bbs_range"));
//		String bbs_category_string = request.getParameter("bbs_category");
//		int bbs_category = Integer.parseInt(bbs_category_string);
		int bbs_category1 = Integer.parseInt(request.getParameter("kind1"));
		int bbs_category2 = Integer.parseInt(request.getParameter("kind2"));

		//int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));
		System.out.println(user_id);
		System.out.println(bbs_id);
		System.out.println(bbs_title);
		System.out.println(bbs_details);
		System.out.println(bbs_pw);
		System.out.println(bbs_range);
//		System.out.println(bbs_category);

		// 更新または削除を行う
		BbsDAO bDao = new BbsDAO();
		if (request.getParameter("submit").equals("更新")) {
			if(bbs_category1 ==0) {
				bDao.update(new BBS(user_id, bbs_id, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category1));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			} else  {
				bDao.update(new BBS(user_id, bbs_id, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category2));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			}

//			bDao.update(new BBS(user_id, bbs_id, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category));// 更新成功
			System.out.println(user_id);
			System.out.println(bbs_id);
			System.out.println(bbs_title);
			System.out.println(bbs_details);
			System.out.println(bbs_pw);
			System.out.println(bbs_range);
//			System.out.println(bbs_category);


		} else if (request.getParameter("submit").equals("削除")) {
			bDao.delete(bbs_id); // 削除成功
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
			dispatcher.forward(request, response);

		}
		// 掲示板トップページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
//		dispatcher.forward(request, response);
	}

}
