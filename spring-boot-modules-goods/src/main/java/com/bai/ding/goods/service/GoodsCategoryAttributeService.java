package com.bai.ding.goods.service;

import com.bai.ding.common.Result;
import com.bai.ding.goods.models.GoodsCategoryAttribute;
import com.bai.ding.goods.models.condition.QueryCategoryAttributeCondition;

/**
 * 分类属性查询集合
 * @author BaiDing
 * @date 2020/3/25 21:28
 */
public interface GoodsCategoryAttributeService {

    /**
     * 查询分类的属性集合
     * @param condition
     * @return
     */
    Result getGoodsCategoryAttribute(QueryCategoryAttributeCondition condition);

    /**
     * 添加分类属性
     * @param goodsCategoryAttribute
     * @return
     */
    Result addGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute);

    /**
     * 编辑分类属性 (暂时只能编辑名称)
     * @param goodsCategoryAttribute
     * @return
     */
    Result editGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute);

    /**
     * 根据分类属性id删除
     * @param id
     * @return
     */
    Result deleteGoodsCategoryAttribute(long id);
}
