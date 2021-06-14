package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Bbs> select(Bbs param) {
		Connection conn = null;
		List<Bbs> bbsList = new ArrayList<Bbs>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "select id,name,kana,corporation,department,postal,address,tel,fax,cellphone,mail,last_update,remarks from BC where name like ? and corporation like ? and department like ? and address like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getName() != null) {
				pStmt.setString(1, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getKana() != null) {
				pStmt.setString(2, "%" + param.getCorporation() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getCorporation() != null) {
				pStmt.setString(3, "%" + param.getDepartment() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getAddress() != null) {
				pStmt.setString(4, "%" + param.getAddress() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bbs card = new Bbs(
				rs.getInt("id"),
				rs.getString("name"),
				rs.getString("kana"),
				rs.getString("corporation"),
				rs.getString("department"),
				rs.getString("postal"),
				rs.getString("address"),
				rs.getString("tel"),
				rs.getString("fax"),
				rs.getString("cellphone"),
				rs.getString("mail"),
				rs.getString("last_update"),
				rs.getString("remarks")
				);
				bbsList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			bbsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			bbsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					bbsList = null;
				}
			}
		}

		// 結果を返す
		return bbsList;
	}
}