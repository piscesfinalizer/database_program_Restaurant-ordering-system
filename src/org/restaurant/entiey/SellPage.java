package org.restaurant.entiey;

import java.util.List;

public class SellPage {
    private int currentPage;
    private int pageSize;
    private List<Sell> sells;
    private int totalCount;
    private int totalPage;

    public SellPage(){

    }

    public SellPage(int currentPage, int pageSize, List<Sell> sells, int totalCount, int totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.sells = sells;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
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

    public List<Sell> getSells() {
        return sells;
    }

    public void setSells(List<Sell> sells) {
        this.sells = sells;
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
