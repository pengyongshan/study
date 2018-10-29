package com.tree.www.minimvc.dao;

import com.tree.www.minimvc.annotation.Repository;

/**
 * Created by pysh on 2018/10/24.
 */
@Repository("userDao")
public class UserDao {
    public void insert() {
        System.out.println("excute UserDao.insert...");
    }
}
