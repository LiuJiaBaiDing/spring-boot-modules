package com.bai.ding.goods.models;

import java.io.Serializable;
import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/24 14:32
 */
public class GoodsCategory implements Serializable {

    private long id;
    private long parentId;
    private String categoryName;
    private int categoryLevel;
    /**
     * 是否有效 1为无效 默认为0
     */
    private int removed;
    private List<GoodsCategory> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(int categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public int getRemoved() {
        return removed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public List<GoodsCategory> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryLevel=" + categoryLevel +
                ", removed=" + removed +
                ", children=" + children +
                '}';
    }
}
