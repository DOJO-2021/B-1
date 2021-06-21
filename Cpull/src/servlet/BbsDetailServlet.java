package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	//	HttpSession session = request.getSession();
		//セッションスコープからインスタンスを取得
	//	String bbs_id
		//bbs_id b =(bbs_id) session.getAttribute("bbs_id");


		//sql文を実行
		//今回はダミーで掲示板idは”1”で実行
		//String bbs_id ="1";
		int bbs_id = 1;
//				Integer.parseInt(request.getParameter("bbs_id"));
		//System.out.println(int_id);
		//詳細データを抽出（掲示板idをキーに）
		BbsDAO bDao = new BbsDAO();
		List<BBS> bbsList = bDao.detailselect(new BBS("",bbs_id,"","","",0,0));

		//書き込みデータを抽出（掲示板idをキーに）
		BbsReplyDAO brDao = new BbsReplyDAO();
		List<Reply> replyList = brDao.replyselect(new Reply(bbs_id,"","",0,""));


		// 検索結果をリクエストスコープに格納する
				request.setAttribute("bbsList", bbsList);
				request.setAttribute("replyList", replyList);

		//リクエストスコープからインスタンスを取得
			//	BBS bt =(BBS) request.getAttribute("bbs_title");
			//	BBS bd =(BBS) request.getAttribute("bbs_details");
			//	Reply rc =(Reply) request.getAttribute("Reply_contents");
		//詳細データをセッションスコープに保存する
	//	HttpSession session = request.getSession();
	//	request.setAttribute("bbs_id", new Reply(bbs_id));

		//詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_detail.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//リクエストスコープ
		request.setCharacterEncoding("UTF-8");

		String bbs_id_string = request.getParameter("bbs_id");
		int bbs_id = Integer.parseInt(bbs_id_string);
//		LoginUser user_id_id = (LoginUser) session.getAttribute("id");
//		String user_id = user_id_id.getId();
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String reply_range_string= request.getParameter("reply_range");
		int reply_range = Integer.parseInt(reply_range_string);
		String reply_contents = request.getParameter("reply_contents");

//System.out.println(bbs_id);
//System.out.println(user_id);
//System.out.println(user_name);
//System.out.println(reply_range);
//System.out.println(reply_contents);
		// コメントを行う
		BbsReplyDAO bDao = new BbsReplyDAO();
		bDao.insert(new Reply(0,user_id,user_name,reply_range,reply_contents));

		// detailページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
	dispatcher.forward(request, response);

	}


}
