package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BBS;

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
