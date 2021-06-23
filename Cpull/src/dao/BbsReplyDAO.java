package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reply;

public class BbsReplyDAO {
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
			String sql = "insert into reply values (null,?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (replycard.getReply_id() != 0) {
				pStmt.setInt(1, replycard.getReply_id());
			} else {
				pStmt.setInt(1, 0);
			}

			if (replycard.getUser_id() != null) {
				pStmt.setString(2, replycard.getUser_id());
			} else {
				pStmt.setString(2, "null");
			}
			if (replycard.getUser_name() != null) {
				pStmt.setString(3, replycard.getUser_name());
			} else {
				pStmt.setString(3, "null");
			}

			if (replycard.getReply_range() != 0) {
				pStmt.setInt(4, replycard.getReply_range());
			} else {
				pStmt.setInt(4, 0);
			}
			if (replycard.getReply_contents() != null) {
				pStmt.setString(5, replycard.getReply_contents());
			} else {
				pStmt.setString(5, "null");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Reply> replyselect(Reply param) {
		Connection conn = null;
		List<Reply> replyList = new ArrayList<Reply>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "select * from reply where bbs_id= ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getBbs_id() != 00) {
					pStmt.setInt(1, param.getBbs_id() );
				}
				else {
					pStmt.setInt(1,00);
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Reply card = new Reply(
						rs.getInt("reply_id"),
						rs.getInt("bbs_id"),
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getInt("reply_range"),
						rs.getString("reply_contents"));
				replyList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			replyList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			replyList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					replyList = null;
				}
			}
		}

		// 結果を返す
		return replyList;
	}

}