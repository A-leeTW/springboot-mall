package com.andylee.springbootmall.util;

import java.util.List;

// 此 class 用來轉換前端顯示方式
public class Page<T> {

    private Integer limit;
    private Integer offset;
    private Integer total;
    private List<T> results;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
