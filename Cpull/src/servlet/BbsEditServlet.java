package servlet;

import java.io.IOException;
import java.util.List;

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
		LoginUser user = (LoginUser) session.getAttribute("user");
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id_id = request.getParameter("user_id");
//		System.out.println(bbs_id);
		System.out.println("user_id_id"+user_id_id);
		System.out.println("user.getId"+user.getId());


//		if (user.getId() == null) {
//			response.sendRedirect("/Cpull/LoginServlet");
//			return;
//		}
//		else
			if (!(user.getId().equals(user_id_id)) ) {
//			response.sendRedirect("/WEB-INF/jsp/bbs_top.jsp");
			//スレッドtopページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
			dispatcher.forward(request, response);
			System.out.println("not eqaual");
			return;
		}
//		else if (user.getId() == request.getParameter("user_id")) {
//			//スレッドtopページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
//			dispatcher.forward(request, response);
//			return;
//		}

//		else if  (session.getAttribute("user_id") == (BBS)request.getAttribute("user_id")) {
//			request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
//			return;


		//リクエストスコープの「bbs_id」を変数(bbs_id)に入れる
		//select user_id from BBS where bbs_id の結果を受け取る(String型のuser_id)
		//上のString型のuser_idとsession.getAttribute("id")(これは今このページにログインしている人のID)
		//が等しいかどうかを判別式にする
		//真(True)の場合は/WEB-INF/jsp/bbs_edit.jspにフォワードする


		//sql文を実行
		//今回はダミーで掲示板idは”1”で実行
		//String bbs_id ="1";
		//int bbs_id = 1;
		///			Integer.parseInt(request.getParameter("bbs_id"));
		//System.out.println(int_id);
		//リクエストスコープ
		request.setCharacterEncoding("UTF-8");
//		LoginUser user = (LoginUser) session.getAttribute("user");
				String user_id = user.getId();
				String bbs_id_string = request.getParameter("bbs_id");
				int bbs_id = Integer.parseInt(bbs_id_string);
//				System.out.println(bbs_id);
//				System.out.println(user_id);


		//		//詳細データを抽出（掲示板idをキーに）
				BbsDAO bDao = new BbsDAO();
				List<BBS> bbsList = bDao.detailselect(new BBS("", bbs_id, "", "", "", 0, 0));
		//
		//		// 検索結果をリクエストスコープに格納する
				request.setAttribute("bbsList", bbsList);

		//リクエストスコープからインスタンスを取得
		//	BBS bt =(BBS) request.getAttribute("bbs_title");
		//	BBS bd =(BBS) request.getAttribute("bbs_details");
		//	Reply rc =(Reply) request.getAttribute("Reply_contents");
		//詳細データをセッションスコープに保存する
		//	HttpSession session = request.getSession();
		//	request.setAttribute("bbs_id", new Reply(bbs_id));

		//スレッド編集ページにフォワードする
		System.out.println("eqaual");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
		dispatcher.forward(request, response);
	}

}
