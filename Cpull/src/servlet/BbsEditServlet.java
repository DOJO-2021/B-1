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
import dao.BbsDraftDAO;
import model.BBS;
import model.Draft;

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
//			HttpSession session = request.getSession();
//				if (session.getAttribute("user_id") == null) {
//					response.sendRedirect("/B-1/LoginServlet");
//					return;
//				} else if(session.getAttribute("user_id") != ){
		//          response.sendRedirect("/B-1/LoginServlet");
//					return;
		//
		//セッションスコープの取得
	//	HttpSession session = request.getSession();
		//セッションスコープからインスタンスを取得
	//	String bbs_id
		//bbs_id b =(bbs_id) session.getAttribute("bbs_id");


		//sql文を実行
		//今回はダミーで掲示板idは”1”で実行
		//String bbs_id ="1";
		int bbs_id = 1;
///			Integer.parseInt(request.getParameter("bbs_id"));
		//System.out.println(int_id);
		//詳細データを抽出（掲示板idをキーに）
		BbsDAO bDao = new BbsDAO();
		List<BBS> bbsList = bDao.detailselect(new BBS("",bbs_id,"","","",0,0));



		// 検索結果をリクエストスコープに格納する
				request.setAttribute("bbsList", bbsList);

		//リクエストスコープからインスタンスを取得
			//	BBS bt =(BBS) request.getAttribute("bbs_title");
			//	BBS bd =(BBS) request.getAttribute("bbs_details");
			//	Reply rc =(Reply) request.getAttribute("Reply_contents");
		//詳細データをセッションスコープに保存する
	//	HttpSession session = request.getSession();
	//	request.setAttribute("bbs_id", new Reply(bbs_id));


		//スレッド編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//			if (session.getAttribute("id") == null) {
//				response.sendRedirect("/B-1/LoginUserServlet");
//		return;
//		}
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
//				LoginUser user_id_id = (LoginUser) session.getAttribute("id");
//				String user_id = user_id_id.getId();
				String user_id = request.getParameter("user_id");
				String bbs_id_string = request.getParameter("bbs_id");
				int bbs_id = Integer.parseInt(bbs_id_string);
				String bbs_title = request.getParameter("bbs_title");
				String bbs_details = request.getParameter("bbs_details");
				String bbs_pw= request.getParameter("bbs_pw");
				String bbs_range_string= request.getParameter("bbs_range");
				int bbs_range = Integer.parseInt(bbs_range_string);
				//int bbs_range= Integer.parseInt(request.getParameter("bbs_range"));
				String bbs_category_string= request.getParameter("bbs_category");
				int bbs_category = Integer.parseInt(bbs_category_string);

				//int bbs_category = Integer.parseInt(request.getParameter("bbs_category"));

				System.out.println(bbs_id);

				// 更新または削除を行う
				BbsDAO bDao = new BbsDAO();
				BbsDraftDAO brDao = new BbsDraftDAO();
				if (request.getParameter("submit").equals("更新")) {

					bDao.update(new BBS(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));// 更新成功
				}
				else if(request.getParameter("submit").equals("削除")) {
					bDao.delete(bbs_id) ;	// 削除成功

				}
				else if(request.getParameter("submit").equals("下書き保存")){
					brDao.insert(new Draft(user_id,0,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category));
				}
				// 掲示板トップページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
				dispatcher.forward(request, response);
			}
		}
