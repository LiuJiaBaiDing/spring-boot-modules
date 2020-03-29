package com.bai.ding.goods.dao;

import com.bai.ding.goods.models.Goods;
import com.bai.ding.goods.models.condition.QueryGoodsCondition;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/26 18:16
 */
public interface GoodsDao {

    /**
     * 根据条件 得到列表分页数据
     * @param condition
     * @return
     */
    List<Goods> getAllGoods(QueryGoodsCondition condition);

    /**
     * 根据条件得到 商品总数量
     * @param condition
     * @return
     */
    int getAllGoodsCount(QueryGoodsCondition condition);
}
