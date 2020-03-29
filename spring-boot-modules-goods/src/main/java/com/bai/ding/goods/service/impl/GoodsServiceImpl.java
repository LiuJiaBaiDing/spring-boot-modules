package com.bai.ding.goods.service.impl;

import com.bai.ding.common.Page;
import com.bai.ding.common.Result;
import com.bai.ding.goods.dao.GoodsDao;
import com.bai.ding.goods.models.Goods;
import com.bai.ding.goods.models.condition.QueryGoodsCondition;
import com.bai.ding.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/26 18:16
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao;

    @Override
    public Result getAllGoods(QueryGoodsCondition condition) {
        int count = goodsDao.getAllGoodsCount(condition);
        List<Goods> list = goodsDao.getAllGoods(condition);
        Page<Goods> page = new Page.Builder<Goods>().setPageNow(condition.getCurrent())
                .setPageSize(condition.getPageSize()).setRecordTotal(count).setList(list).build();
        return new Result.Builder().ok().setMessage("商品列表如下：").setData(page).build();
    }


    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

}
