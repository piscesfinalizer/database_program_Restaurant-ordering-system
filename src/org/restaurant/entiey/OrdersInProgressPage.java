package org.restaurant.entiey;

import java.util.List;

public class OrdersInProgressPage {
    private List<OrdersInProgress> ordersInProgresses;
    private int currentPage;
    private int pageSize;
    private int totalCount;
    private int totalPage;

    public OrdersInProgressPage(){

    }

    public OrdersInProgressPage(List<OrdersInProgress> ordersInProgresses, int currentPage, int pageSize, int totalCount, int totalPage) {
        this.ordersInProgresses = ordersInProgresses;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public List<OrdersInProgress> getOrdersInProgresses() {
        return ordersInProgresses;
    }

    public void setOrdersInProgresses(List<OrdersInProgress> ordersInProgresses) {
        this.ordersInProgresses = ordersInProgresses;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.totalPage = this.totalCount % this.pageSize == 0? this.totalCount/this.pageSize : (this.totalCount/this.pageSize)+1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

}
