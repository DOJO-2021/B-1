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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	* @param bbs_id
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String bbs_range_string = request.getParameter("bbs_range");
		int bbs_range = Integer.parseInt(bbs_range_string);
		//int bbs_range = Integer.parseInt(request.getParameter("bbs_range"));
		String bbs_category_string = request.getParameter("bbs_category");
		int bbs_category = Integer.parseInt(bbs_category_string);
		//int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));
//				System.out.println(user_id);
//				System.out.println(bbs_title);
//				System.out.println(bbs_details);
//				System.out.println(bbs_pw);
//				System.out.println(bbs_range);
//				System.out.println(bbs_category);

		//submitのパラメータが「作成」の時の処理を書く。その後サーブレットに移動
		BbsDAO bDao = new BbsDAO();
		BbsDraftDAO drDao = new BbsDraftDAO();
		if (request.getParameter("submit").equals("bbs_create")) {
			bDao.insert(new BBS(user_id, 0, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category));

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
			dispatcher.forward(request, response);
		}
		//submitのパラメータが「下書き保存」の時の処理を書く。その後サーブレットに移動
		//「下書きテーブル」に追加
		else if (request.getParameter("submit").equals("draft_save")) {
			drDao.insert(new Draft(user_id, 0, bbs_title, bbs_details, bbs_pw, bbs_range, bbs_category));

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
			dispatcher.forward(request, response);
		}
		//submitのパラメータが「下書き読み込み」の時の処理を書く。その後サーブレットに移動
		//「draft」からキーをもとに検索(ユーザーID （セッションスコープ利用）、、抽出、（削除or読み込み済みチェック？）
		else if (request.getParameter("submit").equals("draft_load")) {

			List<Draft> draftList = drDao.draftselect(new Draft(user_id, 0, "", "", "", 0, 0));
			if(draftList.size()<1) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_create.jsp");
				dispatcher.forward(request, response);
			}
			request.setAttribute("draftList", draftList);
			int bbs_id = draftList.get(0).getBbs_id();
			System.out.println(bbs_id);
			drDao.delete(bbs_id); // 削除成功

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_create.jsp");
			dispatcher.forward(request, response);
		}
		// 登録を行う
		//		BbsDAO bDao = new BbsDAO();
		//		BbsDraftDAO drDao = new BbsDraftDAO();
		//		 if (request.getParameter("submit").equals("作成")) {
		//		 bDao.insert(new BBS(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));
		//		 } else if(request.getParameter("submit").equals("下書き")) {
		//		drDao.insert(new Draft(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));
		//		 }

		// 掲示板トップページにフォワードする
		//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
		//		dispatcher.forward(request, response);
	}
}
