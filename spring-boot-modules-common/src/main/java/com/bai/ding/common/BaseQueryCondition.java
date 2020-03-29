package com.bai.ding.common;

/**
 * @author BaiDing
 * @date 2020/3/23 11:36
 */
public class BaseQueryCondition {

    /**
     * 如果当前页为0，则代表查询所有数据
     */
    private Integer current = 0;
    private Integer pageSize = 50;
    private Integer start = 0;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        setStart();
    }

    public Integer getStart() {
        return start;
    }

    private void setStart() {
        this.start = this.current > 1 ? (this.current - 1) * pageSize : 0;
    }
}
