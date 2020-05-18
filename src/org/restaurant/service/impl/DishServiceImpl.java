package org.restaurant.service.impl;

import org.restaurant.dao.IDishDao;
import org.restaurant.dao.impl.DishDaoImpl;
import org.restaurant.entiey.Dish;
import org.restaurant.service.IDishService;

import java.util.List;

public class DishServiceImpl implements IDishService {
    IDishDao dishDao = new DishDaoImpl();

    @Override
    public boolean addDish(Dish dish) {
        if(!dishDao.isExist(dish.getDno())){//不存在
            return dishDao.addDish(dish);
        }else {
            System.out.println("此菜品已存在！");
            return false;
        }
    }

    @Override
    public boolean deleteDishByDno(String dno) {
        if(dishDao.isExist(dno)){

            return dishDao.deleteDishByDno(dno);
        }else {
            return false;
        }
    }

    @Override
    public boolean updateDishByDno(String dno, Dish dish) {
        if (dishDao.isExist(dno)){
            return dishDao.updateDishByDno(dno,dish);
        }else {
            return false;
        }
    }

    @Override
    public Dish queryDishByDno(String dno) {
        return dishDao.queryDishByDno(dno);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from mainDishes";
        return dishDao.getTotalCount(sql);
    }

    @Override
    public List<Dish> queryDishesByPage(int currentPage, int pageSize) {
        return dishDao.queryDishesByPage(currentPage, pageSize);
    }

    @Override
    public List<Dish> queryAllDishes() {
        return dishDao.queryAllDishes();
    }

}
