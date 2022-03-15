package com.tree.www.jdbc;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by pysh on 2022/3/14.
 */
public class CategoryInit {
  public static void main(String[] args) throws Exception {

    String fileName = "/Users/pysh/Downloads/ae_category.json";
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
    String lineTxt;
    while ((lineTxt = br.readLine()) != null) { //数据以逗号分隔
      List<Category> categories = JSON.parseArray(lineTxt, Category.class);
      saveCategorys(categories);
    }
    br.close();
    connection.close();
  }

  private static Connection connection = DBUtil.getConnection();

  private static void saveCategorys(List<Category> categories) throws Exception {
    if (connection.isClosed()) {
      connection = DBUtil.getConnection();
    }
    String selectSql = "select * from k_outer_category where id = ? and outer_id = 20001";
    PreparedStatement selectStatement = connection.prepareStatement(selectSql);
    String insertSql = "REPLACE INTO `ims`.`k_outer_category`(`id`, `outer_id`, `code`, `name`, `level`, `parent_id`, `path`, `creator`, `modifier`) VALUES " +
        "(?, 20001, ?, ?, ?, ?, ?, 'admin', 'admin')";
    PreparedStatement insertStatement = connection.prepareStatement(insertSql);
    StringBuilder path = new StringBuilder();
    for (int i = 0; i < categories.size(); i++) {
      Category category = categories.get(i);
      path.append(i > 0 ? ", " : "").append(category.getCategoryEnName());
      selectStatement.setLong(1, category.getCategoryId());
      ResultSet rs = selectStatement.executeQuery();
      if (!rs.next()) {
        insertStatement.setLong(1, category.getCategoryId());
        insertStatement.setString(2, category.getCategoryEnName());
        insertStatement.setString(3, category.getCategoryEnName());
        insertStatement.setInt(4, i + 1);
        insertStatement.setLong(5, i == 0 ? 0 : categories.get(i - 1).getCategoryId());
        insertStatement.setString(6, path.toString());
        insertStatement.executeUpdate();
      }
    }
  }

  public static class Category {
    private String categoryEnName;
    private Long categoryId;

    public String getCategoryEnName() {
      return categoryEnName;
    }

    public void setCategoryEnName(String categoryEnName) {
      this.categoryEnName = categoryEnName;
    }

    public Long getCategoryId() {
      return categoryId;
    }

    public void setCategoryId(Long categoryId) {
      this.categoryId = categoryId;
    }
  }
}
