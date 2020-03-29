package com.bai.ding.goods.controller;

import com.bai.ding.common.Result;
import com.bai.ding.goods.models.GoodsCategory;
import com.bai.ding.goods.models.condition.QueryCategoryCondition;
import com.bai.ding.goods.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author BaiDing
 * @date 2020/3/24 15:07
 */
@RestController
public class GoodsCategoryController {

    private GoodsCategoryService goodsCategoryService;

    @GetMapping("/categories")
    public Result getAllGoodsCategory(QueryCategoryCondition condition){
        return goodsCategoryService.getGoodsCategoryAll(condition);
    }

    @PostMapping("/category")
    public Result addGoodsCategory(@RequestBody GoodsCategory goodsCategory){
        return goodsCategoryService.addGoodsCategory(goodsCategory);
    }

    @DeleteMapping("/category/{id}")
    public Result deleteGoodsCategory(@PathVariable("id") long id){
        return goodsCategoryService.deleteGoodsCategory(id);
    }

    @PutMapping("/category")
    public Result editGoodsCategory(@RequestBody GoodsCategory goodsCategory){
        return goodsCategoryService.editGoodsCategory(goodsCategory);
    }

    @Autowired
    public void setGoodsCategoryService(GoodsCategoryService goodsCategoryService) {
        this.goodsCategoryService = goodsCategoryService;
    }
}
