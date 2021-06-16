package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	// ログインできるならtrueを返す
	public boolean isLoginOK(String id, String pw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

			// SELECT文を準備する
			String sql = "select count(*) from M_USER where USER_ID = ? and USER_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			pStmt.setString(2, pw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User card) { // cardリスト？確認
		Connection conn = null;
		boolean result = false;


		// System.out.println(card.toString()); // 項目が合っているかの確認

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "INSERT INTO M_USER (user_id, user_name, user_pw, user_k_name, user_company, user_class, user_prefecture, user_hobby, user_skill, user_birth, user_remarks, user_range, user_image)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getUser_name() != null) {
				pStmt.setString(2, card.getUser_name());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getUser_pw() != null) {
				pStmt.setString(3, card.getUser_pw());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getUser_k_name() != null) {
				pStmt.setString(4, card.getUser_k_name());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getUser_company() != null) {
				pStmt.setString(5, card.getUser_company());
			}
			else {
				pStmt.setString(5, null);
			}
			// if (card.getUser_class() != 0) {
				pStmt.setInt(6, card.getUser_class());
			// }
			// else {
			//	pStmt.setString(6, null);
			// }
			if (card.getUser_prefecture() != null) {
				pStmt.setString(7, card.getUser_prefecture());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getUser_hobby() != null) {
				pStmt.setString(8, card.getUser_hobby());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getUser_skill() != null) {
				pStmt.setString(9, card.getUser_skill());
			}
			else {
				pStmt.setString(9, null);
			}
			if (card.getUser_birth() != null) {
				pStmt.setString(10, card.getUser_birth());
			}
			else {
				pStmt.setString(10, null);
			}
			if (card.getUser_remarks() != null) {
				pStmt.setString(11, card.getUser_remarks());
			}
			else {
				pStmt.setString(11, null);
			}
			// if (card.getUser_range() != null) {
				pStmt.setInt(12, card.getUser_range());
			// }
			// else {
			//	pStmt.setString(12, null);
			//}
			if (card.getUser_image() != null) {
				pStmt.setString(13, card.getUser_image());
			}
			else {
				pStmt.setString(13, null);
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(User card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "update M_USER set user_name=?, user_pw=?, user_k_name=?, user_company=?, user_class=?, user_prefecture=?, user_hobby=?, user_skill=?, user_birth=?, user_remarks=?, user_range=?, user_image=?"
					+ "where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_name() != null) {
				pStmt.setString(1, card.getUser_name());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getUser_pw() != null) {
				pStmt.setString(2, card.getUser_pw());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getUser_k_name() != null) {
				pStmt.setString(3, card.getUser_k_name());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getUser_company() != null) {
				pStmt.setString(4, card.getUser_company());
			}
			else {
				pStmt.setString(4, null);
			}
			// if (card.getUser_class() != null) {
				pStmt.setInt(5, card.getUser_class());
			// }
			// else {
			//	pStmt.setInt(5, null);
			// }
			if (card.getUser_prefecture() != null) {
				pStmt.setString(6, card.getUser_prefecture());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getUser_hobby() != null) {
				pStmt.setString(7, card.getUser_hobby());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getUser_skill() != null) {
				pStmt.setString(8, card.getUser_skill());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getUser_birth() != null) {
				pStmt.setString(9, card.getUser_birth());
			}
			else {
				pStmt.setDate(9, null);
			}
			if (card.getUser_remarks() != null) {
				pStmt.setString(10, card.getUser_remarks());
			}
			else {
				pStmt.setString(10, null);
			}
			// if (card.getUser_range() != null) {
				pStmt.setInt(11, card.getUser_range());
			// }
			// else {
			//	pStmt.setInt(11, null);
			// }
			if (card.getUser_image() != null) {
				pStmt.setString(12, card.getUser_image());
			}
			else {
				pStmt.setString(12, null);
			}
			pStmt.setString(13, card.getUser_id());


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