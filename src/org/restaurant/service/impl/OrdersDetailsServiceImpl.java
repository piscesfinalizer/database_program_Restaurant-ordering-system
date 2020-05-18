package org.restaurant.service.impl;

import org.restaurant.dao.IOrdersDetailsDao;
import org.restaurant.dao.impl.OrdersDetailsImpl;
import org.restaurant.entiey.OrderDetail;
import org.restaurant.service.IOrdersDetailsService;

import java.util.List;

public class OrdersDetailsServiceImpl implements IOrdersDetailsService {
    IOrdersDetailsDao ordersDetailsDao = new OrdersDetailsImpl();

    @Override
    public List<OrderDetail> queryOrderDetailsByPage(int currentPage, int pageSize, int flag) {
        return ordersDetailsDao.queryOrderDetailsByPage(currentPage, pageSize, flag);
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail, int flag) {
        if(!ordersDetailsDao.isExist(orderDetail.getOno(),orderDetail.getDno(),flag)){
            return ordersDetailsDao.addOrderDetail(orderDetail,flag);
        }else {
            System.out.println("此记录已存在");
            return false;
        }
    }

    @Override
    public boolean deleteOrderDetail(String ono, String dno) {
        if(ordersDetailsDao.isExist(ono,dno,1)){
            return ordersDetailsDao.deleteOrderDetail(ono,dno);
        }else {
            System.out.println("此记录不存在");
            return false;
        }
    }

    @Override
    public int getTotalCount(int flag) {
        String sql = null;
        if(flag == 1){
            sql = "select count(1) from ordersInProgressDetails";
        }else {
            sql = "select count(1) from finishedOrdersDetails";
        }
        return ordersDetailsDao.getTotalCount(sql);
    }

    @Override
    public OrderDetail querySingleOrderDetail(String ono, String dno, int flag) {
        return ordersDetailsDao.querySingleOrderDetail(ono,dno,flag);
    }

    @Override
    public List<OrderDetail> queryOrderDetailsByOno(String ono, int flag) {
        return ordersDetailsDao.queryOrderDetailsByOno(ono, flag);
    }
}
