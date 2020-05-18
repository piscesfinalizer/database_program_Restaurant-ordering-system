package org.restaurant.service;

import org.restaurant.entiey.Dish;

import java.util.List;

public interface IDishService {

    public boolean addDish(Dish dish);

    public boolean deleteDishByDno(String dno);

    public boolean updateDishByDno(String dno, Dish dish);

    public Dish queryDishByDno(String dno);

    public int getTotalCount();

    public List<Dish> queryDishesByPage(int currentPage, int pageSize);

    public List<Dish> queryAllDishes();

}
