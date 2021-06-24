package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginUser;
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
				pStmt.setString(9, null);
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

	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<User> select(User param) {
			Connection conn = null;
			List<User> cardList = new ArrayList<User>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

				// SQL文を準備する
				String sql = "SELECT * FROM M_USER WHERE user_id LIKE ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getUser_id() != null) {
					pStmt.setString(1, param.getUser_id());
				}
				else {
					pStmt.setString(1, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					User card = new User(
					rs.getString("user_id"),
					rs.getString("user_name"),
					rs.getString("user_pw"),
					rs.getString("user_k_name"),
					rs.getString("user_company"),
					rs.getInt("user_class"),
					rs.getString("user_prefecture"),
					rs.getString("user_hobby"),
					rs.getString("user_skill"),
					rs.getString("user_birth"),
					rs.getString("user_remarks"),
					rs.getInt("user_range"),
					rs.getString("user_image")
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
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public LoginUser userselect(LoginUser param) {
			Connection conn = null;
//			List<User> cardList = new ArrayList<User>();
			LoginUser user = new LoginUser();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-1/Cpull/cpull", "sa", "sa");

				// SQL文を準備する
				String sql = "SELECT user_class,user_name from M_USER WHERE user_id LIKE ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getId() != null) {
					pStmt.setString(1, param.getId());
//					System.out.println(param.getId());
				}
				else {
					pStmt.setString(1, "%");
				}

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				rs.next();
					user.setUser_class(rs.getInt("user_class")) ;
					user.setUser_name(rs.getString("user_name")) ;

//					rs.getString("user_id"),
//					rs.getString("user_name"),
//					rs.getString("user_pw"),
//					rs.getString("user_k_name"),
//					rs.getString("user_company"),
//					rs.getInt("user_class"),
//					rs.getString("user_prefecture"),
//					rs.getString("user_hobby"),
//					rs.getString("user_skill"),
//					rs.getString("user_birth"),
//					rs.getString("user_remarks"),
//					rs.getInt("user_range"),
//					rs.getString("user_image")
//					);
//					cardList.add(card);
//				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				user = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				user = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						user = null;
					}
				}
			}

			// 結果を返す
			return user;
		}

}