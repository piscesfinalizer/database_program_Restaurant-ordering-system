package org.restaurant.service.impl;

import org.restaurant.dao.IOrdersFinishedDao;
import org.restaurant.dao.impl.OrdersFinishedDaoImpl;
import org.restaurant.entiey.OrdersFinished;
import org.restaurant.service.IOrdersFinishedService;

import java.util.List;

public class OrdersFinishedServiceImpl implements IOrdersFinishedService {
    IOrdersFinishedDao ordersFinishedDao = new OrdersFinishedDaoImpl();

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from finishedOrders";
        return ordersFinishedDao.getTotalCount(sql);
    }

    @Override
    public List<OrdersFinished> queryOrdersFinishedByPage(int currentPage, int pageSize) {
        return ordersFinishedDao.queryOrdersFinishedByPage(currentPage, pageSize);
    }

    @Override
    public boolean addOrdersFinished(OrdersFinished ordersFinished) {
        if (!ordersFinishedDao.isExist(ordersFinished.getOno())){
            return ordersFinishedDao.addOrdersFinished(ordersFinished);
        }else {
            System.out.println("添加失败!");
            return false;
        }
    }

    @Override
    public OrdersFinished queryOrdersFinishedByOno(String ono) {
        return ordersFinishedDao.queryOrdersFinishedByOno(ono);
    }

}
