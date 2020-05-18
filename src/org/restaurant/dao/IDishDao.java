package org.restaurant.dao;

import org.restaurant.entiey.Box;
import org.restaurant.entiey.Dish;

import java.util.List;

public interface IDishDao {
    public List<Dish> queryDishesByPage(int currentPage, int pageSize);

    public int getTotalCount(String sql);//查询总数据的条数

    public Dish queryDishByDno(String dno);

    public boolean isExist(String dno);

    public boolean addDish(Dish dish);

    public boolean updateDishByDno(String dno,Dish dish);

    public boolean deleteDishByDno(String dno);

    public List<Dish> queryAllDishes();
}
