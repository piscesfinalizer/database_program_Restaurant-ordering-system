package org.restaurant.dao;

import org.restaurant.entiey.OrdersFinished;

import java.util.List;

public interface IOrdersFinishedDao {
    public int getTotalCount(String sql);

    public List<OrdersFinished> queryOrdersFinishedByPage(int currentPage, int pageSize);

    public boolean addOrdersFinished(OrdersFinished ordersFinished);

    public boolean isExist(String ono);

    public OrdersFinished queryOrdersFinishedByOno(String ono);
}
