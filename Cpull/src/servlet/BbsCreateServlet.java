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
import dao.BbsDraftDAO;
import model.BBS;
import model.Draft;
import model.LoginUser;
/**
 * Servlet implementation class BbsCreateServlet
 */
@WebServlet("/BbsCreateServlet")
public class BbsCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		 HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B-1/LoginServlet");
			return;

		}



		//スレッド新規作成ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_create.jsp");
		dispatcher.forward(request, response);
	}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// もしもログインしていなかったらログインサーブレットにリダイレクトする
	HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B-1/LoginUserServlet");
	return;
	}
// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		LoginUser user_id_id = (LoginUser) session.getAttribute("id");
		String user_id = user_id_id.getId();
		String bbs_title = request.getParameter("bbs_title");
		String bbs_details = request.getParameter("bbs_details");
		String bbs_pw = request.getParameter("bbs_pw");
		String bbs_range_string= request.getParameter("bbs_range");
		int bbs_range = Integer.parseInt(bbs_range_string);
		//int bbs_range = Integer.parseInt(request.getParameter("bbs_range"));
		String bbs_category_string= request.getParameter("bbs_category");
		int bbs_category = Integer.parseInt(bbs_category_string);
		//int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));
//		System.out.println(user_id);
//		System.out.println(bbs_title);
//		System.out.println(bbs_details);
//		System.out.println(bbs_pw);
//		System.out.println(bbs_range);
//		System.out.println(bbs_category);
		// 登録を行う
		BbsDAO bDao = new BbsDAO();
		BbsDraftDAO drDao = new BbsDraftDAO();
		 if (request.getParameter("submit").equals("作成")) {
		 bDao.insert(new BBS(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));
		 } else if(request.getParameter("submit").equals("下書き")) {
		drDao.insert(new Draft(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));
		 }

		// 掲示板トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
		dispatcher.forward(request, response);
}

}
