package com.bai.ding.goods.models.condition;

import com.bai.ding.common.BaseQueryCondition;

/**
 * @author BaiDing
 * @date 2020/3/26 18:13
 */
public class QueryGoodsCondition extends BaseQueryCondition {

    /**
     * 商品名称模糊查询
     */
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
