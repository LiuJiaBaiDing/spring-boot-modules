package com.bai.ding.goods.models;

/**
 * @author BaiDing
 * @date 2020/3/25 21:19
 */
public class GoodsCategoryAttribute {

    private long id;
    private String attributeName;
    private long categoryId;
    private String attributeSel;
    private String attributeWrite;
    private String attributeValues = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttributeSel() {
        return attributeSel;
    }

    public void setAttributeSel(String attributeSel) {
        this.attributeSel = attributeSel;
    }

    public String getAttributeWrite() {
        return attributeWrite;
    }

    public void setAttributeWrite(String attributeWrite) {
        this.attributeWrite = attributeWrite;
    }

    public String getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(String attributeValues) {
        this.attributeValues = attributeValues;
    }

    @Override
    public String toString() {
        return "GoodsCategoryAttribute{" +
                "id=" + id +
                ", attributeName='" + attributeName + '\'' +
                ", categoryId=" + categoryId +
                ", attributeSel='" + attributeSel + '\'' +
                ", attributeWrite='" + attributeWrite + '\'' +
                ", attributeValues='" + attributeValues + '\'' +
                '}';
    }
}
