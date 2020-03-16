package com.bai.ding.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author BaiDing
 * @date 2020/3/10 0:27
 */
@Controller
public class Admin {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
