package org.restaurant.service;

import org.restaurant.entiey.OrdersFinished;

import java.util.List;

public interface IOrdersFinishedService {

    public int getTotalCount();

    public List<OrdersFinished> queryOrdersFinishedByPage(int currentPage, int pageSize);

    public boolean addOrdersFinished(OrdersFinished ordersFinished);

    public OrdersFinished queryOrdersFinishedByOno(String ono);
}
