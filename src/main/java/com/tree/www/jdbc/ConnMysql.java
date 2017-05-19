package com.tree.www.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnMysql {

	public static void main(String[] args) throws Exception {

		// String sql = "update student_table set student_name='pys' where
		// student_id < 3";
		String sql = "truncate  teacher_table";

		// 自动关闭
		Connection connection = DBUtil.getConnection();
		Statement stmt = connection.createStatement();
		boolean flag = stmt.execute(sql);

		if (flag) {
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString("teacher_name"));
			}
		} else {
			System.out.println(stmt.getUpdateCount());
		}
	}
}
