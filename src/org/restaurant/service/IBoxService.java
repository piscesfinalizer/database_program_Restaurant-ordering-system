package org.restaurant.service;

import org.restaurant.entiey.Box;

import java.util.List;

public interface IBoxService {
    public List<Box> queryAllBoxes();

    public int getTotalCount();

    public List<Box> queryBoxesByPage(int currentPage, int pageSize);

    public boolean addBox(Box box);

    public Box queryAppropriateBoxes(int diners);
}
