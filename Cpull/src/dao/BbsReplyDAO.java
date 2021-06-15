package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reply;

//引数cardで指定されたレコードを登録し、成功したらtrueを返す
// public boolean insert(Reply card) {
	//	Connection conn = null;
		//boolean result = false;
	public class BbsReplyDAO{
		// 引数inquirycardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Reply replycard) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into reply values (null, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (replycard.getbbs_id() != null) {
				pStmt.setString(1, replycard.getbbs_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (replycard.getuser_id() != null) {
				pStmt.setString(2, replycard.getuser_id());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (replycard.getuser_name() != null) {
				pStmt.setString(3, replycard.getuser_name());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (replycard.getreply_range() != null) {
				pStmt.setString(4, replycard.getreply_range());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (replycard.getreply_contens() != null) {
				pStmt.setString(5, replycard.getreply_contents());
			}
			else {
				pStmt.setString(5, "null");
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Reply> select(Reply param) {
			Connection conn = null;
			List<Reply> cardList = new ArrayList<Reply>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

				// SQL文を準備する
				String sql = "select *from reply ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Reply card = new Reply(
					rs.getString("bbs_id"),
					rs.getString("user_id"),
					rs.getString("user_name"),
					rs.getString("reply_range"),
					rs.getString("reply_contents")
							);
					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}

}