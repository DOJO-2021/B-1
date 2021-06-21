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
	public List<BBS> wordselect(BBS param) {
		Connection conn = null;
		List<BBS> bbsList = new ArrayList<BBS>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "select user_id,bbs_id,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category from bbs where bbs_title like ?";
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

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<BBS> categoryselect(BBS param) {
		Connection conn = null;
		List<BBS> bbsList = new ArrayList<BBS>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "select user_id,bbs_id,bbs_title,bbs_details,bbs_pw,bbs_range,bbs_category from bbs where bbs_category = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getBbs_category() != 5) {
				pStmt.setInt(1, /*"%" + */param.getBbs_category() /*+ "%"*/);
			}
			else {
				pStmt.setInt(1, 5);
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

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(BBS card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into BBS values (?,null,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (card.getBbs_title() != null) {
				pStmt.setString(2, card.getBbs_title());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (card.getBbs_details() != null) {
				pStmt.setString(3, card.getBbs_details());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (card.getBbs_pw() != null) {
				pStmt.setString(4, card.getBbs_pw());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (card.getBbs_range() != 0) {
				pStmt.setInt(5, card.getBbs_range());
			}
			else {
				pStmt.setInt(5, 0);
			}
			if (card.getBbs_category() != 0) {
				pStmt.setInt(6, card.getBbs_category());
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(BBS card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "update bbs set user_id=?,bbs_title=?,bbs_details=?,bbs_pw=?,bbs_range=?,bbs_category=? where bbs_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (card.getBbs_title() != null) {
				pStmt.setString(2, card.getBbs_title());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (card.getBbs_details() != null) {
				pStmt.setString(3, card.getBbs_details());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (card.getBbs_pw() != null) {
				pStmt.setString(4, card.getBbs_pw());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (card.getBbs_range() != 0) {
				pStmt.setInt(5, card.getBbs_range());
			}
			else {
				pStmt.setInt(5, 0);
			}
			if (card.getBbs_category() != 0) {
				pStmt.setInt(6, card.getBbs_category());
			}
			else {
				pStmt.setInt(6, 0);
			}
			pStmt.setInt(7, card.getBbs_id());

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
			String sql = "delete from BBS where bbs_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, bbs_id);

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
	public List<BBS> detailselect(BBS param) {
		Connection conn = null;
		List<BBS> bbsList = new ArrayList<BBS>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-1\\Cpull\\cpull", "sa", "sa");

			// SQL文を準備する
			String sql = "select * from BBS where bbs_id= 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				/*		if (param.getBbs_category() != 1) {
							pStmt.setInt(1, param.getBbs_category() );
						}
						else {
							pStmt.setInt(1, 1);
						}*/
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
