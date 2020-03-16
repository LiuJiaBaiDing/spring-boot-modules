package com.bai.ding.user.dao;

import com.bai.ding.user.models.User;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/10 1:07
 */
public interface UserDAO {

    List<User> getAllUser();

    User getUser(long id);
}
