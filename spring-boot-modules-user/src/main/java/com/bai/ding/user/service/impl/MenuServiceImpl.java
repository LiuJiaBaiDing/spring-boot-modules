package com.bai.ding.user.service.impl;

import com.bai.ding.user.dao.MenuDAO;
import com.bai.ding.user.models.Menu;
import com.bai.ding.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/22 23:09
 */
@Service
public class MenuServiceImpl implements MenuService {

    private MenuDAO menuDAO;

    @Override
    public List<Menu> getAllMenu(long id) {
        List<Menu> menuList = menuDAO.getMenuByParentId(id);
        if (menuList != null && menuList.size() > 0) {
            menuList.forEach(menu -> {
                List<Menu> list = getAllMenu(menu.getId());
                menu.setChildren(list);
            });
        }
        return menuList;
    }

    @Autowired
    public void setMenuDAO(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }
}
