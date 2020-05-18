package org.restaurant.service;

import org.restaurant.entiey.OrderDetail;

import java.util.List;

public interface IOrdersDetailsService {
    public List<OrderDetail> queryOrderDetailsByPage(int currentPage, int pageSize, int flag);

    public boolean addOrderDetail(OrderDetail orderDetail,int flag);

    public boolean deleteOrderDetail(String ono,String dno);

    public int getTotalCount(int flag);


    public OrderDetail querySingleOrderDetail(String ono,String dno,int flag);


    public List<OrderDetail> queryOrderDetailsByOno(String ono,int flag);
}
