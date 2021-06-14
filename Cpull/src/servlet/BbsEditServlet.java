package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class BbsEditServlet
 */
@WebServlet("/BbsEditServlet")
public class BbsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/B-1/LoginServlet");
					return;
				}

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = request.getParameter("user_id");
				int bbs_id = Integer.parseInt(request.getParameter("bbs_id"));
				String bbs_title = request.getParameter("bbs_title");
				String bbs_details = request.getParameter("bbs_details");
				String bbs_pw= request.getParameter("bbs_pe");
				int bbs_range= Integer.parseInt(request.getParameter("bbs_range"));
				int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));


				// 更新または削除を行う
				BbsDAO bDao = new BbsDAO();
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			}
		}
