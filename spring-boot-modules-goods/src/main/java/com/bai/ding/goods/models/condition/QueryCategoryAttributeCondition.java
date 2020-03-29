package com.bai.ding.goods.models.condition;

import com.bai.ding.common.BaseQueryCondition;

/**
 * @author BaiDing
 * @date 2020/3/25 21:26
 */
public class QueryCategoryAttributeCondition extends BaseQueryCondition {

    /**
     * 分类ID
     */
    private long categoryId;
    /**
     * only 或 many, 来获取分类静态参数还是动态参数
     */
    private String attributeSel;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttributeSel() {
        return attributeSel;
    }

    public void setAttributeSel(String attributeSel) {
        this.attributeSel = attributeSel;
    }
}
