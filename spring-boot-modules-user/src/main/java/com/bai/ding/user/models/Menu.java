package com.bai.ding.user.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/22 23:00
 */
public class Menu implements Serializable {
    private long id;
    private String name;
    private int order;
    private String path;
    @JsonIgnore
    private long parentId;
    private List<Menu> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", path='" + path + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}
