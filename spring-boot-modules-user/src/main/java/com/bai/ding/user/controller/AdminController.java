package com.bai.ding.user.controller;

import com.bai.ding.common.Result;
import com.bai.ding.user.models.Menu;
import com.bai.ding.user.models.User;
import com.bai.ding.user.service.AdminService;
import com.bai.ding.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理账号的登录、退出功能
 * @author BaiDing
 * @date 2020/3/22 0:25
 */
@RestController
public class AdminController {

    AdminService adminService;
    MenuService menuService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return adminService.login(user);
    }

    @GetMapping("/menus")
    public Result menus(){
        List<Menu> allMenu = menuService.getAllMenu(0L);
        return new Result.Builder().ok().setMessage("获取菜单列表成功！").setData(allMenu).build();
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
