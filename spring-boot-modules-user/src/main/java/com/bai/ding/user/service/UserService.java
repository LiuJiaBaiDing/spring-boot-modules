package com.bai.ding.user.service;

import com.bai.ding.user.models.User;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/10 16:21
 */
public interface UserService {

    List<User> getAllUser();

    User getUser(long id);
}
