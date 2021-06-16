package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class ProfileDAO {
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
			String sql = "select user_id, user_name, user_pw,user_k_name, user_company,user_class, user_prefecture, user_hobby, user_skill, user_birth, user_remarks, user_range, user_image from m_user where user_name like ? and user_company like ? and user_prefecture like ? and user_hobby like ? and user_skill like ? and user_birth like ? and user_remarks like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);//決まり文句


			// SQL文を完成させる
			if (param.getUser_name() != null) {
			pStmt.setString(1, "%" + param.getUser_name() + "%");
			}
			else {
			pStmt.setString(1, "%");
			}
			if (param.getUser_company() != null) {
			pStmt.setString(2, "%" + param.getUser_company() + "%");
			}
			else {
			pStmt.setString(2, "%");
			}
			if (param.getUser_prefecture() != null) {
			pStmt.setString(3, "%" + param.getUser_prefecture() + "%");
			}
			else {
			pStmt.setString(3, "%");
			}
			if (param.getUser_hobby() != null) {
			pStmt.setString(4, "%" + param.getUser_hobby() + "%");
			}
			else {
			pStmt.setString(4, "%");
			}
			if (param.getUser_skill() != null) {
			pStmt.setString(5, "%" + param.getUser_skill() + "%");
			}
			else {
			pStmt.setString(5, "%");
			}
			if (param.getUser_birth() != null) {
			pStmt.setString(6, "%" + param.getUser_birth() + "%");
			}
			else {
			pStmt.setString(6, "%");
			}
			if (param.getUser_remarks() != null) {
			pStmt.setString(7, "%" + param.getUser_remarks() + "%");
			}
			else {
			pStmt.setString(7, "%");
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
}
