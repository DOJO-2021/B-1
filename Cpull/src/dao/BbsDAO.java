package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BBS;

public class BbsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<BBS> select(BBS param) {
		Connection conn = null;
		List<BBS> bbsList = new ArrayList<BBS>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "select bbs_title from bbs where bbs_title like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getBbs_title() != null) {
				pStmt.setString(1, "%" + param.getBbs_title() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				BBS card = new BBS(
				rs.getString("user_id"),
				rs.getInt("bbs_id"),
				rs.getString("bbs_title"),
				rs.getString("bbs_details"),
				rs.getString("bbs_pw"),
				rs.getInt("bbs_range"),
				rs.getInt("bbs_category")
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
