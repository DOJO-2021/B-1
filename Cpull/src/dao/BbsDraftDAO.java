package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Draft;

public class BbsDraftDAO {
	// 引数inquirycardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Draft draftcard) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into draft values (?, null, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (draftcard.getUser_id() != null) {
				pStmt.setString(1, draftcard.getUser_id());
			} else {
				pStmt.setString(1, "null");
			}
			if (draftcard.getDraft_title() != null) {
				pStmt.setString(2, draftcard.getDraft_title());
			} else {
				pStmt.setString(2, "null");
			}
			if (draftcard.getDraft_details() != null) {
				pStmt.setString(3, draftcard.getDraft_details());
			} else {
				pStmt.setString(3, "null");
			}
			if (draftcard.getDraft_pw() != null) {
				pStmt.setString(4, draftcard.getDraft_pw());
			} else {
				pStmt.setString(4, "null");
			}
			if (draftcard.getDraft_range() != 0) {
				pStmt.setInt(5, draftcard.getDraft_range());
			} else {
				pStmt.setInt(5, 0);
			}
			if (draftcard.getDraft_category() != 0) {
				pStmt.setInt(6, draftcard.getDraft_category());
			} else {
				pStmt.setInt(6, 0);
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
	public List<Draft> draftselect(Draft param) {
		Connection conn = null;
		List<Draft> draftList = new ArrayList<Draft>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "select * from Draft where user_id = ?  ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, param.getUser_id());
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Draft card = new Draft(
						rs.getString("user_id"),
						rs.getInt("bbs_id"),
						rs.getString("draft_title"),
						rs.getString("draft_details"),
						rs.getString("draft_pw"),
						rs.getInt("draft_range"),
						rs.getInt("draft_category"));
				draftList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			draftList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			draftList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					draftList = null;
				}
			}
		}

		// 結果を返す
		return draftList;
	}

	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int bbs_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "delete from Draft where bbs_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, bbs_id);

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

}
