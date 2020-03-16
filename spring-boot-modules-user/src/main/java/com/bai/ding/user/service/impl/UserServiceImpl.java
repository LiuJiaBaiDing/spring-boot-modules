package com.bai.ding.user.service.impl;

import com.bai.ding.user.dao.UserDAO;
import com.bai.ding.user.models.User;
import com.bai.ding.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }
}
