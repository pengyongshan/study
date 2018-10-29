package com.tree.www.minimvc.controller;

import com.tree.www.minimvc.annotation.Controller;
import com.tree.www.minimvc.annotation.Qualifier;
import com.tree.www.minimvc.annotation.RequestMapping;
import com.tree.www.minimvc.service.UserService;

/**
 * Created by pysh on 2018/10/24.
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Qualifier("userService")
    private UserService userService;

    public void insert() {
        userService.insert();
    }
}
