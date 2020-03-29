package com.bai.ding.user.service;

import com.bai.ding.common.Result;
import com.bai.ding.user.models.User;
import com.bai.ding.user.models.condition.UserQueryCondition;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/10 16:21
 */
public interface UserService {

    Result getAllUser(UserQueryCondition condition);

    Result changeUserRemoved(User user);

    Result editUser(User user);

    Result addUser(User user);

    Result getUser(long id);

    Result deleteUser(long id);
}
