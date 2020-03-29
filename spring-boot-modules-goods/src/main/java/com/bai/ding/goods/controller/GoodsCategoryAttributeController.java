package com.bai.ding.goods.controller;

import com.bai.ding.common.Result;
import com.bai.ding.goods.models.GoodsCategoryAttribute;
import com.bai.ding.goods.models.condition.QueryCategoryAttributeCondition;
import com.bai.ding.goods.service.GoodsCategoryAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author BaiDing
 * @date 2020/3/25 21:39
 */
@RestController
@RequestMapping("/categories")
public class GoodsCategoryAttributeController {

    private GoodsCategoryAttributeService goodsCategoryAttributeService;

    @GetMapping("/attributes")
    public Result getGoodsCategoryAttribute(QueryCategoryAttributeCondition condition){
        return goodsCategoryAttributeService.getGoodsCategoryAttribute(condition);
    }

    @PostMapping("/attribute")
    public Result addGoodsCategoryAttribute(@RequestBody GoodsCategoryAttribute goodsCategoryAttribute){
        return goodsCategoryAttributeService.addGoodsCategoryAttribute(goodsCategoryAttribute);
    }

    @PutMapping("/attribute")
    public Result editGoodsCategoryAttribute(@RequestBody GoodsCategoryAttribute goodsCategoryAttribute){
        return goodsCategoryAttributeService.editGoodsCategoryAttribute(goodsCategoryAttribute);
    }

    @DeleteMapping("/attribute/{id}")
    public Result deleteGoodsCategoryAttribute(@PathVariable long id){
        return goodsCategoryAttributeService.deleteGoodsCategoryAttribute(id);
    }


    @Autowired
    public void setGoodsCategoryAttributeService(GoodsCategoryAttributeService goodsCategoryAttributeService) {
        this.goodsCategoryAttributeService = goodsCategoryAttributeService;
    }
}
