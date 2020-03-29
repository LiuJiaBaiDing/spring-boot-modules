package com.bai.ding.goods.controller;

import com.bai.ding.common.Result;
import com.bai.ding.goods.models.condition.QueryGoodsCondition;
import com.bai.ding.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BaiDing
 * @date 2020/3/26 18:27
 */
@RestController
public class GoodsController {

    private GoodsService goodsService;

    @GetMapping("/goods")
    public Result getAllGoods(QueryGoodsCondition condition){
        return goodsService.getAllGoods(condition);
    }

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }
}
