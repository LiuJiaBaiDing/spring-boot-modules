package com.bai.ding.goods.dao;

import com.bai.ding.goods.models.GoodsCategoryAttribute;
import com.bai.ding.goods.models.condition.QueryCategoryAttributeCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/25 21:32
 */
public interface GoodsCategoryAttributeDao {

    /**
     * 查询商品分类的属性集合
     * @param condition
     * @return
     */
    List<GoodsCategoryAttribute> getGoodsCategoryAttribute(QueryCategoryAttributeCondition condition);

    /**
     * 添加分类的属性
     * @param goodsCategoryAttribute
     */
    void addGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute);

    /**
     * 编辑分类属性 (暂时只能编辑名称)
     * @param goodsCategoryAttribute
     */
    void editGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute);

    /**
     * 根据属性id删除数据
     * @param id
     */
    void deleteGoodsCategoryAttribute(@Param("id") long id);
}
