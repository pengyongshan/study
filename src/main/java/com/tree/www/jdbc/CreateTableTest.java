package com.tree.www.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = DBUtil.getConnection();
		String sql = "create table if not exists t_student(student_no int auto_increment primary key,student_name varchar(200), password varchar(200))";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		int result = pstmt.executeUpdate();
		if (result != -1) {
			System.out.println("创建表成功。");
			sql = "insert into t_student values(null, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			for (int i = 1; i < 10; i++) {
				pstmt.setString(1, "name" + i);
				pstmt.setString(2, "123456");
				pstmt.executeUpdate();
			}
		}
		pstmt.close();
		connection.close();
	}
}
