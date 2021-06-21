package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Draft;

public class BbsDraftDAO{
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
		String sql = "insert into draft values (null, ?, ?, ?, ?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		// SQL文を完成させる
					if (draftcard.getUser_id() != null) {
						pStmt.setString(1, draftcard.getUser_id());
					}
					else {
						pStmt.setString(1, "null");
					}
					if (draftcard.getDraft_title() != null) {
						pStmt.setString(2, draftcard.getDraft_title());
					}
					else {
						pStmt.setString(2, "null");
					}
					if (draftcard.getDraft_details() != null) {
						pStmt.setString(3, draftcard.getDraft_details());
					}
					else {
						pStmt.setString(3, "null");
					}
					if (draftcard.getDraft_pw() != null) {
						pStmt.setString(4, draftcard.getDraft_pw());
					}
					else {
						pStmt.setString(4, "null");
					}
					if (draftcard.getDraft_range() != 0) {
						pStmt.setInt(5, draftcard.getDraft_range());
					}
					else {
						pStmt.setInt(5, 0);
					}
					if (draftcard.getDraft_category() != 0) {
						pStmt.setInt(6, draftcard.getDraft_category());
					}
					else {
						pStmt.setInt(6, 0);
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
}
