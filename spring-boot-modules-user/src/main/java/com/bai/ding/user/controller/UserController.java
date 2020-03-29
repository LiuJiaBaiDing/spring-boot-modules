package com.bai.ding.user.controller;

import com.bai.ding.common.Result;
import com.bai.ding.common.constant.BackendModulesConstant;
import com.bai.ding.user.dao.UserDAO;
import com.bai.ding.user.models.User;
import com.bai.ding.user.models.condition.UserQueryCondition;
import com.bai.ding.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Result getAllUser(UserQueryCondition condition){
        return userService.getAllUser(condition);
    }

    @PutMapping("/user/removed")
    public Result changeUserRemoved(@RequestBody User user){
        return userService.changeUserRemoved(user);
    }

    @PutMapping("/user")
    public Result editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @PostMapping("/user")
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable("id") long id){
       return userService.deleteUser(id);
    }


}
