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
			HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/B-1/LoginServlet");
					return;
				}
		//スレッド編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("/B-1/LoginUserServlet");
		return;
		}
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				LoginUser user_id_id = (LoginUser) session.getAttribute("id");
				String user_id = user_id_id.getId();
				int bbs_id = Integer.parseInt(request.getParameter("bbs_id"));
				String bbs_title = request.getParameter("bbs_title");
				String bbs_details = request.getParameter("bbs_details");
				String bbs_pw= request.getParameter("bbs_pw");
				int bbs_range= Integer.parseInt(request.getParameter("bbs_range"));
				int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));


				// 更新または削除を行う
				BbsDAO bDao = new BbsDAO();
				BbsDraftDAO brDao = new BbsDraftDAO();
				if (request.getParameter("SUBMIT").equals("更新")) {

					bDao.update(new BBS(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));// 更新成功
				}
				else if(request.getParameter("SUBMIT").equals("削除")) {
					bDao.delete(bbs_id) ;	// 削除成功
				}
				else if(request.getParameter("SUBMIT").equals("下書き保存")){
					brDao.insert(new Draft(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));
				}
				// 掲示板トップページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			}
		}
