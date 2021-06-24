package servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class BbsEditServlet
 */
@WebServlet("/BbsEditServlet")
public class BbsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		//ri
		String bbs_id_string = request.getParameter("bbs_id");
		int bbs_id = Integer.parseInt(bbs_id_string);
		LoginUser user_id_id = (LoginUser) session.getAttribute("id");
		String user_id = user_id_id.getId();

		//詳細データを抽出（掲示板idをキーに）
		BbsDAO bDao = new BbsDAO();
		List<BBS> bbsList = bDao.detailselect(new BBS("", bbs_id, "", "", "", 0, 0));
		request.setAttribute("bbsList", bbsList);
		BBS b = (BBS) request.getAttribute("user_id");

		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B-1/LoginServlet");
			return;
		} else if (session.getAttribute("user_id") != request.getAttribute("user_id")) {
//			response.sendRedirect("/WEB-INF/jsp/bbs_list.jsp");
			request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
			return;
		} else if  (session.getAttribute("user_id") == request.getAttribute("user_id")) {
			request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
			return;

		}
		//リクエストスコープの「bbs_id」を変数(bbs_id)に入れる
		//select user_id from BBS where bbs_id の結果を受け取る(String型のuser_id)
		//上のString型のuser_idとsession.getAttribute("id")(これは今このページにログインしている人のID)
		//が等しいかどうかを判別式にする
		//真(True)の場合は/WEB-INF/jsp/bbs_edit.jspにフォワードする

		//セッションスコープの取得
		//	HttpSession session = request.getSession();
		//セッションスコープからインスタンスを取得
		//	String bbs_id
		//bbs_id b =(bbs_id) session.getAttribute("bbs_id");

		//sql文を実行
		//今回はダミーで掲示板idは”1”で実行
		//String bbs_id ="1";
		//int bbs_id = 1;
		///			Integer.parseInt(request.getParameter("bbs_id"));
		//System.out.println(int_id);
		//リクエストスコープ
//		LoginUser user_id_id = (LoginUser) session.getAttribute("id");
//		String user_id = user_id_id.getId();
		//		String bbs_id_string = request.getParameter("bbs_id");
		//		int bbs_id = Integer.parseInt(bbs_id_string);

		//		//詳細データを抽出（掲示板idをキーに）
		//		BbsDAO bDao = new BbsDAO();
		//		List<BBS> bbsList = bDao.detailselect(new BBS("", bbs_id, "", "", "", 0, 0));
		//
		//		// 検索結果をリクエストスコープに格納する
		//		request.setAttribute("bbsList", bbsList);

		//リクエストスコープからインスタンスを取得
		//	BBS bt =(BBS) request.getAttribute("bbs_title");
		//	BBS bd =(BBS) request.getAttribute("bbs_details");
		//	Reply rc =(Reply) request.getAttribute("Reply_contents");
		//詳細データをセッションスコープに保存する
		//	HttpSession session = request.getSession();
		//	request.setAttribute("bbs_id", new Reply(bbs_id));

//		//スレッド編集ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
//		dispatcher.forward(request, response);
	}

}
