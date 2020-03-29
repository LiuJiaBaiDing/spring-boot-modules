package com.bai.ding.goods.service;

import com.bai.ding.common.Result;
import com.bai.ding.goods.models.condition.QueryGoodsCondition;

/**
 * @author BaiDing
 * @date 2020/3/26 18:15
 */
public interface GoodsService {

    /**]
     * 商品列表分页数据
     * @param condition
     * @return
     */
    Result getAllGoods(QueryGoodsCondition condition);
}
