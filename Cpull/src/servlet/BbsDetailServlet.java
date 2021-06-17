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
import dao.BbsReplyDAO;
import model.BBS;
import model.Reply;


/**
 * Servlet implementation class BbsDetailServlet
 */
@WebServlet("/BbsDetailServlet")
public class BbsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
					//	HttpSession session = request.getSession();
					//	if (session.getAttribute("user_id") == null) {
					//		response.sendRedirect("/B-1/LoginServlet");
					//		return;
					//	}
		//セッションスコープの取得
		BBS getBBS =new GetBBS();
		HttpSession session = request.getSession();
		//セッションスコープからインスタンスを取得

		//リクエストスコープの時
	//	request.setCharacterEncoding("UTF-8");
	//	int bbs_id = Integer.parseInt(request.getParameter("bbs_id"));
	//	String bbs_title = request.getParameter("bbs_title");
	//	String bbs_details = request.getParameter("bbs_details");
	//	String reply_contents = request.getParameter("reply_contents");


		//sql文を実行
		//今回はダミーで掲示板idは”0001”で実行
		String bbs_id ="0001";
		//詳細データを抽出（掲示板idをキーに）
		BbsDAO bDao = new BbsDAO();
		List<BBS> detail = bDao.select(new BBS("",0001,"","","",0,0));

		//書き込みデータを抽出（掲示板idをキーに）
		BbsReplyDAO brDao =new BbsReplyDAO();
		List<Reply> comtents = brDao.select(new Reply(0001,"","","",0,""));

		//詳細データをセッションスコープに保存する
		HttpSession session = request.getSession();
		request.setAttribute("bbs_id", new Reply(bbs_id));

		//スレッド新規作成ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_deteil.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//リクエストスコープ
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String reply_name = request.getParameter("reply_name");
		int reply_range =Integer.parseInt(request.getParameter("reply_range"));
		String reply_contents = request.getParameter("reply_contents");


		// コメントを行う
		BbsReplyDAO bDao = new BbsReplyDAO();
		bDao.insert(new Reply(0,user_id,user_name,reply_name,reply_range,reply_contents));

		// 掲示板トップページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
	dispatcher.forward(request, response);

	}


}
