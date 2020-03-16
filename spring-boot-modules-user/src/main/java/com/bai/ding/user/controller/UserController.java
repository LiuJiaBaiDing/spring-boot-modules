package com.bai.ding.user.controller;

import com.bai.ding.common.constant.BackendModulesConstant;
import com.bai.ding.user.dao.UserDAO;
import com.bai.ding.user.models.User;
import com.bai.ding.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author BaiDing
 * @date 2020/3/10 1:10
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }

    @GetMapping("/message")
    public String getMessage(){
        return BackendModulesConstant.getBaiDingMessage();
    }
}
