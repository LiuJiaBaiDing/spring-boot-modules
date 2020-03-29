package com.bai.ding.goods.dao;

import com.bai.ding.goods.models.GoodsCategory;
import com.bai.ding.goods.models.condition.QueryCategoryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/24 14:43
 */
public interface GoodsCategoryDao {

    /**
     * 根据条件查询分类数量
     * @param condition
     * @return
     */
    int getGoodsCategoryCount(QueryCategoryCondition condition);

    /**
     * 根据条件查询分类
     * @param condition
     * @return
     */
    List<GoodsCategory> getGoodsCategoryAll(QueryCategoryCondition condition);

    /**
     * 根据父分类id及type层级查询其子分类数据
     * @param parentId
     * @param type
     * @return
     */
    List<GoodsCategory> getGoodsCategoryByParentId(@Param("parentId") long parentId, @Param("type") int type);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteGoodsCategory(@Param("id") long id);

    /**
     * 添加分类
     * @param goodsCategory
     */
    void addGoodsCategory(GoodsCategory goodsCategory);

    /**
     * 编辑分类（名称）
     * @param goodsCategory
     */
    void editGoodsCategory(GoodsCategory goodsCategory);
}
