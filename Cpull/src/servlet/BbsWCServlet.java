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
import model.LoginUser;

/**
 * Servlet implementation class BbsWCServlet
 */
@WebServlet("/BbsWCServlet")
public class BbsWCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("user");
		if (user.getId() == null) {
			response.sendRedirect("/Cpull/LoginServlet");
		return;
		}

		//パラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int bbs_category1 = Integer.parseInt(request.getParameter("kind1"));
		int bbs_category2 = Integer.parseInt(request.getParameter("kind2"));

		int user_class = user.getUser_class();

		BBSt t = (BBSt) session.getAttribute("t");
		String bbs_title = t.getBbs_title();

		//検索結果の中からカテゴリー別検索を行う
		BbsDAO bDao = new BbsDAO();
		if(user_class == 0) {
			if(request.getParameter("submit").equals("悩みで検索")) {
				List<BBS> bbsList = bDao.wcselect1(new BBS("",0,bbs_title,"","",0,bbs_category1));

				//結果をリクエストスコープに格納する
				request.setAttribute("bbsList",bbsList);
			}
			else {
				List<BBS> bbsList = bDao.wcselect1(new BBS("",0,bbs_title,"","",0,bbs_category2));

				//結果をリクエストスコープに格納する
				request.setAttribute("bbsList",bbsList);
			}
		} else {
			if(request.getParameter("submit").equals("悩みで検索")) {
				List<BBS> bbsList = bDao.wcselect2(new BBS("",0,bbs_title,"","",0,bbs_category2));

				//結果をリクエストスコープに格納する
				request.setAttribute("bbsList",bbsList);
			}
			else {
				List<BBS> bbsList = bDao.wcselect2(new BBS("",0,bbs_title,"","",0,bbs_category2));

				//結果をリクエストスコープに格納する
				request.setAttribute("bbsList",bbsList);
			}
		}

		//結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bbs_searchresult.jsp");
		dispatcher.forward(request,response);
	}

}
