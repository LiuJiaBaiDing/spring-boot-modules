package com.bai.ding.user.service;

import com.bai.ding.user.models.Menu;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/22 23:09
 */
public interface MenuService {

    /**
     * 得到所有的菜单目录
     * @param id 父菜单id
     * @return
     */
    List<Menu> getAllMenu(long id);
}
