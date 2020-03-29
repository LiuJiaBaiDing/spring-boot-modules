package com.bai.ding.user.service;

import com.bai.ding.common.Result;
import com.bai.ding.user.models.User;

/**
 * @author BaiDing
 * @date 2020/3/22 0:27
 */
public interface AdminService {

    /**
     * 账号登录方法
     * @param user
     */
    public Result login(User user);
}
