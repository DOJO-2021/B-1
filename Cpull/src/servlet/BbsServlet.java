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
import model.BBSt;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//掲示板トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_top.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String bbs_title = request.getParameter("bbs_search");

		// 検索処理を行う
		BbsDAO bDao = new BbsDAO();
		List<BBS> bbsList = bDao.wordselect(new BBS("",0,bbs_title,"","",0,0));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("bbsList", bbsList);

		//検索ワードをセッションスコープに格納する
		BBSt t = new BBSt();
		t.setBbs_title(bbs_title);
		HttpSession session = request.getSession();
		session.setAttribute("t",t);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_searchresult.jsp");
		dispatcher.forward(request, response);
	}

}
