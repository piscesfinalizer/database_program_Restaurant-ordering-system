package org.restaurant.dao;

import org.restaurant.entiey.Box;

import java.util.List;

public interface IBoxDao {
    public List<Box> queryAllBoxes();

    public List<Box> queryBoxesByPage(int currentPage, int pageSize);

    public int getTotalCount(String sql);//查询总数据的条数

    public Box queryBoxByBno(String bno);

    public boolean isExist(String bno);

    public boolean addBox(Box box);

    public Box queryAppropriateBoxes(int diners);
}
