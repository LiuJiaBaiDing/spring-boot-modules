package com.bai.ding.user.dao;

import com.bai.ding.user.models.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/22 23:04
 */
public interface MenuDAO {

    /**
     * 得到所属id的所有下级菜单
     * @param parentId
     * @return
     */
    List<Menu> getMenuByParentId(@Param("parentId") long parentId);
}
