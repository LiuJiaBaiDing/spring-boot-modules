package com.bai.ding.user.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.bai.ding.common.Result;
import com.bai.ding.common.util.JwtUtil;
import com.bai.ding.user.dao.UserDAO;
import com.bai.ding.user.models.User;
import com.bai.ding.user.service.AdminService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author BaiDing
 * @date 2020/3/22 0:27
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserDAO userDAO;

    @Override
    public Result login(User user) {
        String password = MD5.create().digestHex16(user.getPassword());
        User confirmUser = userDAO.getUserByNameAndPassword(user.getName(),password);
        if(null == confirmUser){
            return new Result.Builder().error().setMessage("用户名或密码不正确！").build();
        }
        Map<String,Object> map = Maps.newHashMap();
        String token = JwtUtil.generateJsonWenToken(confirmUser.getId(),confirmUser.getName());
        map.put("id", confirmUser.getId());
        map.put("name", confirmUser.getName());
        map.put("token", token);
        return new Result.Builder().ok().setData(map).build();
    }
}
