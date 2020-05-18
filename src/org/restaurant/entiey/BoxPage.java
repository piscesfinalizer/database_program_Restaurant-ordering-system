package org.restaurant.entiey;

import java.util.List;

public class BoxPage {
    private int currentPage;
    private int pageSize;
    private List<Box> boxes;
    private int totalCount;
    private int totalPage;

    public BoxPage(){

    }

    public BoxPage(int currentPage, int pageSize, List<Box> boxes, int totalCount, int totalPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.boxes = boxes;
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

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
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
