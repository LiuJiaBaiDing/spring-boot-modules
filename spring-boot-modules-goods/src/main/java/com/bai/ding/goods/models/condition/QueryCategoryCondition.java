package com.bai.ding.goods.models.condition;

import com.bai.ding.common.BaseQueryCondition;

/**
 * @author BaiDing
 * @date 2020/3/24 14:39
 */
public class QueryCategoryCondition extends BaseQueryCondition {

    private int parentId;
    /**
     * 代表需要查出几层分类 【1，2，3】
     * 默认查出所有，即三层分类
     */
    private int type;


    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
