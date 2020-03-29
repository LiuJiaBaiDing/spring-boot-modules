package com.bai.ding.goods.service.impl;

import com.bai.ding.common.Result;
import com.bai.ding.goods.dao.GoodsCategoryAttributeDao;
import com.bai.ding.goods.models.GoodsCategoryAttribute;
import com.bai.ding.goods.models.condition.QueryCategoryAttributeCondition;
import com.bai.ding.goods.service.GoodsCategoryAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/25 21:30
 */
@Service
public class GoodsCategoryAttributeServiceImpl implements GoodsCategoryAttributeService {

    private GoodsCategoryAttributeDao goodsCategoryAttributeDao;

    @Override
    public Result getGoodsCategoryAttribute(QueryCategoryAttributeCondition condition) {
        List<GoodsCategoryAttribute> list = goodsCategoryAttributeDao.getGoodsCategoryAttribute(condition);
        return new Result.Builder().ok().setMessage("获取属性成功").setData(list).build();
    }

    @Override
    public Result addGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        goodsCategoryAttributeDao.addGoodsCategoryAttribute(goodsCategoryAttribute);
        return new Result.Builder().ok().setMessage("添加属性成功").build();
    }

    @Override
    public Result editGoodsCategoryAttribute(GoodsCategoryAttribute goodsCategoryAttribute) {
        goodsCategoryAttributeDao.editGoodsCategoryAttribute(goodsCategoryAttribute);
        return new Result.Builder().ok().setMessage("编辑属性成功").build();
    }

    @Override
    public Result deleteGoodsCategoryAttribute(long id) {
        goodsCategoryAttributeDao.deleteGoodsCategoryAttribute(id);
        return new Result.Builder().ok().setMessage("删除属性成功").build();
    }

    @Autowired
    public void setGoodsCategoryAttributeDao(GoodsCategoryAttributeDao goodsCategoryAttributeDao) {
        this.goodsCategoryAttributeDao = goodsCategoryAttributeDao;
    }
}
