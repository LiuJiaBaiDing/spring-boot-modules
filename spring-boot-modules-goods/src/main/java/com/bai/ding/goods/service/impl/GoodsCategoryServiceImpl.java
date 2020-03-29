package com.bai.ding.goods.service.impl;

import com.bai.ding.common.Page;
import com.bai.ding.common.Result;
import com.bai.ding.goods.dao.GoodsCategoryDao;
import com.bai.ding.goods.models.GoodsCategory;
import com.bai.ding.goods.models.condition.QueryCategoryCondition;
import com.bai.ding.goods.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/24 14:43
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    GoodsCategoryDao goodsCategoryDao;

    @Override
    public Result getGoodsCategoryAll(QueryCategoryCondition condition) {
        int count = goodsCategoryDao.getGoodsCategoryCount(condition);
        List<GoodsCategory> list = goodsCategoryDao.getGoodsCategoryAll(condition);
        list.forEach(goodsCategory -> {
            List<GoodsCategory> subList = getSubGoodsCategory(goodsCategory.getId(), condition.getType());
            if(subList != null && subList.size() > 0){
                goodsCategory.setChildren(subList);
            }
        });
        Page<GoodsCategory> page = new Page.Builder<GoodsCategory>().setPageNow(condition.getCurrent())
                .setPageSize(condition.getPageSize()).setRecordTotal(count).setList(list).build();
        return new Result.Builder().ok().setMessage("商品分类列表").setData(page).build();
    }

    @Override
    public Result deleteGoodsCategory(long id) {
        deleteSubGoodsCategory(id);
        goodsCategoryDao.deleteGoodsCategory(id);
        return new Result.Builder().ok().setMessage("删除该商品分类成功").build();
    }

    @Override
    public Result addGoodsCategory(GoodsCategory goodsCategory) {
        goodsCategoryDao.addGoodsCategory(goodsCategory);
        return new Result.Builder().ok().setMessage("添加该商品分类成功").build();
    }

    @Override
    public Result editGoodsCategory(GoodsCategory goodsCategory) {
        goodsCategoryDao.editGoodsCategory(goodsCategory);
        return new Result.Builder().ok().setMessage("编辑该商品分类成功").build();
    }

    List<GoodsCategory> getSubGoodsCategory(long parentId, int type) {
        List<GoodsCategory> list = goodsCategoryDao.getGoodsCategoryByParentId(parentId, type);
        if (list != null && list.size() > 0) {
            list.forEach(category -> {
                List<GoodsCategory> subList = goodsCategoryDao.getGoodsCategoryByParentId(category.getId(), type);
                if(subList != null && subList.size() > 0){
                    category.setChildren(subList);
                }
            });
        }
        return list;
    }

    void deleteSubGoodsCategory(long parentId) {
        List<GoodsCategory> list = goodsCategoryDao.getGoodsCategoryByParentId(parentId, 0);
        if (list != null && list.size() > 0) {
            list.forEach(category -> {
                List<GoodsCategory> subList = goodsCategoryDao.getGoodsCategoryByParentId(category.getId(), 0);
                if (subList != null && subList.size() > 0) {
                    deleteSubGoodsCategory(category.getId());
                }
                goodsCategoryDao.deleteGoodsCategory(category.getId());
            });
        }
    }

    @Autowired
    public void setGoodsCategoryDao(GoodsCategoryDao goodsCategoryDao) {
        this.goodsCategoryDao = goodsCategoryDao;
    }
}
