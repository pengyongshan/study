package com.tree.www.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementTest {
	public static void main(String[] args) throws SQLException {
		PreparedStatementTest pt = new PreparedStatementTest();
		pt.insertUseStatement();
		pt.insertUsePreparedStatment();
	}

	public void insertUseStatement() throws SQLException {
		long start = System.currentTimeMillis();
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "";
		for (int i = 0; i < 100; i++) {
			sql = "insert into student_table values(null,'姓名" + i + "', 1)";
			stmt.executeUpdate(sql);
		}
		System.out.println("耗时：" + (System.currentTimeMillis() - start));
		stmt.close();
		conn.close();
	}

	public void insertUsePreparedStatment() throws SQLException {
		long start = System.currentTimeMillis();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into student_table values(null,?, 1)");
		String sql = "";
		for (int i = 0; i < 100; i++) {
			pstmt.setString(1, "姓名" + i);
			pstmt.executeUpdate();
		}
		System.out.println("耗时：" + (System.currentTimeMillis() - start));
		pstmt.close();
		conn.close();
	}
}
