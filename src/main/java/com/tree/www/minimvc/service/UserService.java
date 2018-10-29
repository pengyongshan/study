package com.tree.www.minimvc.service;

import com.tree.www.minimvc.annotation.Qualifier;
import com.tree.www.minimvc.annotation.Service;
import com.tree.www.minimvc.dao.UserDao;

/**
 * Created by pysh on 2018/10/24.
 */
@Service("userService")
public class UserService {

    @Qualifier("userDao")
    private UserDao userDao;

    public void insert() {
        System.out.println("userService insert start");
        userDao.insert();
        System.out.println("userService insert end");
    }
}
