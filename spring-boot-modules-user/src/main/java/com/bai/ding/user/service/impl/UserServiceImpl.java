package com.bai.ding.user.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.bai.ding.common.Page;
import com.bai.ding.common.Result;
import com.bai.ding.user.dao.UserDAO;
import com.bai.ding.user.models.User;
import com.bai.ding.user.models.condition.UserQueryCondition;
import com.bai.ding.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/10 16:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Result getAllUser(UserQueryCondition condition) {
        int count = userDAO.getAllUserCount(condition);
        List<User> list = userDAO.getAllUser(condition);

        Page<User> page = new Page.Builder<User>().setPageSize(condition.getPageSize()).setPageNow(condition.getCurrent())
                .setRecordTotal(count).setList(list).build();
        return new Result.Builder().ok().setMessage("当前页用户列表").setData(page).build();
    }

    @Override
    public Result changeUserRemoved(User user) {
        userDAO.changeUserRemoved(user);
        return new Result.Builder().ok().setMessage("修改状态成功").build();
    }

    @Override
    public Result editUser(User user) {
        userDAO.editUser(user);
        return new Result.Builder().ok().setMessage("编辑用户成功").build();
    }

    @Override
    public Result addUser(User user) {
        String password = MD5.create().digestHex16(user.getPassword());
        user.setPassword(password);
        user.setRegisterDate(LocalDateTime.now());
        userDAO.addUser(user);
        return new Result.Builder().ok().setMessage("添加用户成功").build();
    }

    @Override
    public Result getUser(long id) {
        return new Result.Builder().ok().setMessage("查询用户成功").setData(userDAO.getUser(id)).build();
    }

    @Override
    public Result deleteUser(long id) {
        userDAO.deleteUser(id);
        return new Result.Builder().ok().setMessage("删除用户成功").build();
    }
}
