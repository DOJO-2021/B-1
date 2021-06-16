package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDAO;
import model.BBS;

/**
 * Servlet implementation class BbsEditServlet
 */
@WebServlet("/BbsEditServlet")
public class BbsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			//	HttpSession session = request.getSession();
			//	if (session.getAttribute("user_id") == null) {
			//		response.sendRedirect("/B-1/LoginServlet");
			//		return;

		//スレッド新規作成ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = request.getParameter("user_id");
				int bbs_id = Integer.parseInt(request.getParameter("bbs_id"));
				String bbs_title = request.getParameter("bbs_title");
				String bbs_details = request.getParameter("bbs_details");
				String bbs_pw= request.getParameter("bbs_pw");
				int bbs_range= Integer.parseInt(request.getParameter("bbs_range"));
				int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));


				// 更新または削除を行う
				BbsDAO bDao = new BbsDAO();
				if (request.getParameter("SUBMIT").equals("更新")) {

					bDao.update(new BBS(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));// 更新成功
				}
				else if(request.getParameter("SUBMIT").equals("削除")) {
					bDao.delete(bbs_id) ;	// 削除成功
				}
				else {
					bDao.insert(new BBS());
				}
				// 掲示板トップページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			}
		}
