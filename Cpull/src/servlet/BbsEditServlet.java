package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Bbs;
import model.Bbs;
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
				if (request.getParameter("SUBMIT").equals("更新")) {

					if (bDao.update(new Bbs(user_id, bbs_id, bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category))) {	// 更新成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/B-1/MenuServlet"));
					}
					else {												// 更新失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/B-1/MenuServlet"));
					}
				}
				else {
					if (bDao.delete(bbs_id)) {	// 削除成功
						request.setAttribute("result",
						new Result("削除成功！", "レコードを削除しました。", "/B-1/MenuServlet"));
					}
					else {						// 削除失敗
						request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/B-1/MenuServlet"));
					}
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			}
		}
