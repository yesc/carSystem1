package com.jkxy.car.api.utils;

import java.util.List;

/**
 * 分页对象
 */
public class Pager<T> {

    private int current;

    private int size;

    private Long total;

    private List<T> data;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Pager() {
    }

    public Pager(int current, int size, Long total, List<T> data) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.data = data;
    }
}
