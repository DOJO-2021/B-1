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
import model.BBS;
/**
 * Servlet implementation class BbsListServlet
 */
@WebServlet("/BbsListServlet")
public class BbsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 検索処理を行う
		BbsDAO bDao = new BbsDAO();
		List<BBS> bbsList = bDao.wordselect(new BBS("",0,"","","",0,0));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("bbsList", bbsList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_list.jsp");
		dispatcher.forward(request, response);
	}

}
