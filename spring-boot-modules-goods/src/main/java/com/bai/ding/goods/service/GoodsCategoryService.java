package com.bai.ding.goods.service;

import com.bai.ding.common.Result;
import com.bai.ding.goods.models.GoodsCategory;
import com.bai.ding.goods.models.condition.QueryCategoryCondition;

/**
 * @author BaiDing
 * @date 2020/3/24 14:41
 */
public interface GoodsCategoryService {

    /**
     * 根据条件查询商品分类
     *
     * @param condition
     * @return
     */
    Result getGoodsCategoryAll(QueryCategoryCondition condition);

    /**
     * 删除分类，同时会删除子分类
     *
     * @param id
     * @return
     */
    Result deleteGoodsCategory(long id);

    /**
     * 添加分类
     *
     * @param goodsCategory
     * @return
     */
    Result addGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 编辑分类 主要编辑分类名称
     *
     * @param goodsCategory
     * @return
     */
    Result editGoodsCategory(GoodsCategory goodsCategory);
}
