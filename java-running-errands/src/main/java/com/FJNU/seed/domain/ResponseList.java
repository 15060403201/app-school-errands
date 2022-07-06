package com.FJNU.seed.domain;

import java.util.List;

import com.FJNU.seed.model.OrderInfo;

public class ResponseList {
    private Integer total;
    private List<OrderInfo> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<OrderInfo> getList() {
        return list;
    }

    public void setList(List<OrderInfo> list) {
        this.list = list;
    }
}