package com.bai.ding.user.models.condition;

import com.bai.ding.common.BaseQueryCondition;

/**
 * @author BaiDing
 * @date 2020/3/23 11:21
 */
public class UserQueryCondition extends BaseQueryCondition {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
