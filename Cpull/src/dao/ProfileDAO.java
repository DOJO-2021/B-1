package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bc;

public class BcDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Bc> select(Bc param) {
		Connection conn = null;
		List<Bc> cardList = new ArrayList<Bc>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "select businesscard_id, company_name, department_name, full_name, zipcode, address, tel, fax, email, remarks from BC where company_name like ? and full_name like ? and address like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			if (param.getCompany_name() != null) {
			pStmt.setString(1, "%" + param.getCompany_name() + "%");
			}
			else {
			pStmt.setString(1, "%");
			}
			if (param.getFull_name() != null) {
			pStmt.setString(2, "%" + param.getFull_name() + "%");
			}
			else {
			pStmt.setString(2, "%");
			}
			if (param.getAddress() != null) {
			pStmt.setString(3, "%" + param.getAddress() + "%");
			}
			else {
			pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bc card = new Bc(
				rs.getInt("businesscard_id"),
				rs.getString("company_name"),
				rs.getString("department_name"),
				rs.getString("full_name"),
				rs.getString("zipcode"),
				rs.getString("address"),
				rs.getString("tel"),//プロフィールの結果記入
				rs.getString("fax"),
				rs.getString("email"),
				rs.getString("remarks")
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

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "insert into BC values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany_name() != null) {
				pStmt.setString(1, card.getCompany_name());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (card.getDepartment_name() != null) {
				pStmt.setString(2, card.getDepartment_name());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (card.getFull_name() != null) {
				pStmt.setString(3, card.getFull_name());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (card.getZipcode() != null) {
				pStmt.setString(4, card.getZipcode());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (card.getAddress() != null) {
				pStmt.setString(5, card.getAddress());
			}
			else {
				pStmt.setString(6, "null");
			}
			if (card.getTel() != null) {
				pStmt.setString(6, card.getTel());
			}
			else {
				pStmt.setString(6, "null");
			}
			if (card.getFax() != null) {
				pStmt.setString(7, card.getFax());
			}
			else {
				pStmt.setString(7, "null");
			}
			if (card.getEmail() != null) {
				pStmt.setString(8, card.getEmail());
			}
			else {
				pStmt.setString(8, "null");
			}
			if (card.getRemarks() != null) {
				pStmt.setString(9, card.getRemarks());
			}
			else {
				pStmt.setString(9, "null");
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
	public boolean update(Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "update BC set company_name=?, department_name=?, full_name=?, zipcode=?, address=?, tel=?, fax=?, email=?, remarks=? where businesscard_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (card.getCompany_name() != null) {
				pStmt.setString(1, card.getCompany_name());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (card.getDepartment_name() != null) {
				pStmt.setString(2, card.getDepartment_name());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (card.getFull_name() != null) {
				pStmt.setString(3, card.getFull_name());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (card.getZipcode() != null) {
				pStmt.setString(4, card.getZipcode());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (card.getAddress() != null) {
				pStmt.setString(5, card.getAddress());
			}
			else {
				pStmt.setString(5, "null");
			}
			if (card.getTel() != null) {
				pStmt.setString(6, card.getTel());
			}
			else {
				pStmt.setString(6, "null");
			}
			if (card.getFax() != null) {
				pStmt.setString(7, card.getFax());
			}
			else {
				pStmt.setString(7, "null");
			}
			if (card.getEmail() != null) {
				pStmt.setString(8, card.getEmail());
			}
			else {
				pStmt.setString(8, "null");
			}
			if (card.getRemarks() != null) {
				pStmt.setString(9, card.getRemarks());
			}
			else {
				pStmt.setString(9, "null");
			}
			pStmt.setInt(10, card.getBusinesscard_id());

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

	// 引数idで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int businesscard_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する いまここ
			String sql = "delete from BC where businesscard_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			pStmt.setInt(1, businesscard_id);

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
