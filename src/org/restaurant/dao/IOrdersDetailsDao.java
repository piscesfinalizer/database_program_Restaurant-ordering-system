package org.restaurant.dao;

import org.restaurant.entiey.OrderDetail;

import java.util.List;

public interface IOrdersDetailsDao {

    public List<OrderDetail> queryOrderDetailsByPage(int currentPage,int pageSize,int flag);

    public boolean addOrderDetail(OrderDetail orderDetail,int flag);

    public boolean deleteOrderDetail(String ono,String dno);

    public int getTotalCount(String sql);

    public boolean isExist(String ono,String dno,int flag);

    public OrderDetail querySingleOrderDetail(String ono,String dno,int flag);

    public List<OrderDetail> queryOrderDetailsByOno(String ono,int flag);

}
