package org.restaurant.service.impl;

import org.restaurant.dao.IOrdersInProgressDao;
import org.restaurant.dao.impl.OrdersInProgressDaoImpl;
import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.service.IOrdersInProgressService;

import java.util.List;

public class OrdersInProgressServiceImpl implements IOrdersInProgressService {
    IOrdersInProgressDao ordersInProgressDao = new OrdersInProgressDaoImpl();


    @Override
    public boolean addOrdersInProgress(OrdersInProgress ordersInProgress) {
        if(!ordersInProgressDao.isExist(ordersInProgress.getOno())){//不存在
            return ordersInProgressDao.addOrdersInProgress(ordersInProgress);
        }else {
            System.out.println("此消费单已存在！");
            return false;
        }
    }

    @Override
    public boolean deleteOrdersInProgressByOno(String ono) {
        if(ordersInProgressDao.isExist(ono)){

            return ordersInProgressDao.deleteOrdersInProgressByOno(ono);
        }else {
            return false;
        }
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from ordersInProgress";
        return ordersInProgressDao.getTotalCount(sql);
    }

    @Override
    public List<OrdersInProgress> queryOrdersInProgressByPage(int currentPage, int pageSize) {
        return ordersInProgressDao.queryOrdersInProgressByPage(currentPage, pageSize);
    }

}
