package com.bai.ding.admin.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/30 19:02
 */
public class Dog implements Serializable {

    private long id;
    private String name;
    private int age;
    private List<Dog> children;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Dog> getChildren() {
        return children;
    }

    public void setChildren(List<Dog> children) {
        this.children = children;
    }
}
