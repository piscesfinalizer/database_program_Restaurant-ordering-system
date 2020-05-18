package org.restaurant.service;

import org.restaurant.entiey.OrdersInProgress;

import java.util.List;

public interface IOrdersInProgressService {
    public boolean addOrdersInProgress(OrdersInProgress ordersInProgress);

    public boolean deleteOrdersInProgressByOno(String ono);

    public int getTotalCount();

    public List<OrdersInProgress> queryOrdersInProgressByPage(int currentPage, int pageSize);

}
