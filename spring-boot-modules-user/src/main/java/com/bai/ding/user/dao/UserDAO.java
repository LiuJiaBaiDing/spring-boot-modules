package com.bai.ding.user.dao;

import com.bai.ding.user.models.User;
import com.bai.ding.user.models.condition.UserQueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/10 1:07
 */
public interface UserDAO {

    List<User> getAllUser(UserQueryCondition condition);

    int getAllUserCount(UserQueryCondition condition);

    void changeUserRemoved(User user);

    void editUser(User user);

    void addUser(User user);

    User getUser(long id);

    void deleteUser(@Param("id") long id);

    User getUserByNameAndPassword(@Param("name") String name, @Param("password")String password);
}
