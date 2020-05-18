package org.restaurant.dao;

import org.restaurant.entiey.OrdersInProgress;

import java.util.List;

public interface IOrdersInProgressDao {
    public int getTotalCount(String sql);

    public boolean addOrdersInProgress(OrdersInProgress ordersInProgress);

    public boolean deleteOrdersInProgressByOno(String ono);

    public boolean isExist(String ono);

    public List<OrdersInProgress> queryOrdersInProgressByPage(int currentPage, int pageSize);

    public OrdersInProgress queryOrdersInProgressByOno(String ono);


}
