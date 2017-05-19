package com.tree.www.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class DatabaseMetaDataTest {

	public void info() throws Exception {
		Connection connection = DBUtil.getConnection();
		DatabaseMetaData dbmd = connection.getMetaData();
		ResultSet rs = dbmd.getTableTypes();
		System.out.println("--mysql支持的表类型");
		printRs(rs);

		rs = dbmd.getTables(null, null, "%", new String[] { "TABLE" });
		System.out.println("--当前数据库的数据表信息--");
		printRs(rs);

		rs = dbmd.getPrimaryKeys(null, null, "t_student");
		System.out.println("--t_student表的主键信息--");
		printRs(rs);

		rs = dbmd.getProcedures(null, null, "%");
		System.out.println("--当前数据库的所有存储过程--");
		printRs(rs);

		rs = dbmd.getCrossReference(null, null, "teach_table", null, null, "student_table");
		System.out.println("--两表之间的外键约束--");
		printRs(rs);

		rs = dbmd.getColumns(null, null, "t_student", "%");
		System.out.println("--t_studnet的所有列");
		printRs(rs);
		connection.close();
	}

	private void printRs(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i + 1) + "\t");
		}
		System.out.println();
		while (rs.next()) {
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.print(rs.getString(i + 1) + "\t");
			}
			System.out.println();
		}
		rs.close();
	}

	public static void main(String[] args) throws Exception {
		new DatabaseMetaDataTest().info();
	}
}
