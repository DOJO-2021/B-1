package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Inquiry;

public class InquiryDAO {
	// 引数inquirycardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Inquiry inquirycard) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する //後で参照ファイルを指定
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into Inquiry values(null, 0, ?, ?, ?,)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (inquirycard.getSubject() != null) {
				pStmt.setString(1, inquirycard.getSubject());
			} else {
				pStmt.setString(1, "null");
			}
			if (inquirycard.getMessage() != null) {
				pStmt.setString(2, inquirycard.getMessage());
			} else {
				pStmt.setString(2, "null");
			}
			if (inquirycard.getTs() != null) {
				pStmt.setTimestamp(3, inquirycard.getTs());
			} else {
				pStmt.setTimestamp(3, null);
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


}