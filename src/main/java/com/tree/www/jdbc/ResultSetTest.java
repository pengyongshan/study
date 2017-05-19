package com.tree.www.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class ResultSetTest {
	public static void main(String[] args) throws SQLException {
		new ResultSetTest().query("select * from t_student");
	}

	public void query(final String sql) throws SQLException {
		Connection connection = DBUtil.getConnection();
		// 可滚动 可更新的结果集
		PreparedStatement pstmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = pstmt.executeQuery();

		// 表列名
		ResultSetMetaData metadata = rs.getMetaData();
		for (int i = 1; i <= metadata.getColumnCount(); i++) {
			System.out.print(metadata.getColumnName(i) + "\t");
		}
		System.out.println();

		// 游标指后，倒序输出
		rs.last();
		int rowCount = rs.getRow();
		for (int i = rowCount; i > 0; i--) {
			rs.absolute(i);
			System.out.println(rs.getInt(1) + "\t" + rs.getString("student_name") + "\t" + rs.getString("password"));

			// 可更新数据库
			// rs.updateString(2, "名字" + i);
			// rs.updateRow();
		}

		pstmt.close();
		connection.close();
	}
}
