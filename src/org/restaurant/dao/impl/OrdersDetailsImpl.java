package org.restaurant.dao.impl;

import org.restaurant.dao.IOrdersDetailsDao;
import org.restaurant.entiey.OrderDetail;
import org.restaurant.service.IOrdersInProgressService;
import org.restaurant.service.impl.OrdersInProgressServiceImpl;
import org.restaurant.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDetailsImpl implements IOrdersDetailsDao {
    @Override
    public List<OrderDetail> queryOrderDetailsByPage(int currentPage, int pageSize, int flag) {
        List<OrderDetail> orderDetails = new ArrayList<>();

        String sql = null;

        if(flag == 1){
            sql = "select * from OrdersInProgressDetails order by dno offset ?*? rows fetch next ? rows only";
        }else {
            sql = "select * from finishedOrdersDetails order by dno offset ?*? rows fetch next ? rows only";
        }

        Object[] params = {currentPage-1,pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String ono = rs.getString("ono");
                String dno = rs.getString("dno");
                float dprice = rs.getFloat("dprice");
                int damount = rs.getInt("damount");
                OrderDetail orderDetail = new OrderDetail(ono,dno,dprice,damount);

                orderDetails.add(orderDetail);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return orderDetails;
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail, int flag) {
        String sql = null;
        if (flag == 1){
            sql = "insert into ordersInProgressDetails(ono,dno,dprice,damount) values(?,?,?,?)";
        }else {
            sql = "insert into finishedOrdersDetails(ono,dno,dprice,damount) values(?,?,?,?)";
        }

        Object[] params = {orderDetail.getOno(),orderDetail.getDno(),orderDetail.getDprice(),orderDetail.getDamount()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean deleteOrderDetail(String ono, String dno) {
        String sql = "delete from ordersInProgressDetails where ono = ? and dno = ?";
        Object[] params = {ono,dno};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public int getTotalCount(String sql) {
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public boolean isExist(String ono, String dno, int flag) {
        return querySingleOrderDetail(ono,dno,flag) == null ? false : true;
    }

    @Override
    public OrderDetail querySingleOrderDetail(String ono, String dno, int flag) {
        ResultSet rs = null;
        OrderDetail orderDetail = null;

        try {
            String sql = null;
            if (flag == 1){
                sql = "select * from ordersInProgressDetails where ono = ? and dno = ?";
            }else {
                sql = "select * from finishedOrdersDetails where ono = ? and dno = ?";
            }

            Object[] params = {ono,dno};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String _ono = rs.getString("ono");
                String _dno = rs.getString("dno");
                float dprice = rs.getFloat("dprice");
                int damount = rs.getInt("damount");


                orderDetail = new OrderDetail(_ono,_dno,dprice,damount);

            }

                return orderDetail;
            } catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (rs != null) rs.close();
                    if (DBUtil.con != null) DBUtil.con.close();
                    return orderDetail;
                }catch (SQLException e){
                    e.printStackTrace();
                    return orderDetail;
                }
            }
    }

    @Override
    public List<OrderDetail> queryOrderDetailsByOno(String ono, int flag) {
        List<OrderDetail> orderDetails = new ArrayList<>();

        String sql = null;

        if(flag == 1){
            sql = "select * from OrdersInProgressDetails where ono = ?";
        }else {
            sql = "select * from finishedOrdersDetails where ono = ?";
        }

        Object[] params = {ono};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String _ono = rs.getString("ono");
                String dno = rs.getString("dno");
                float dprice = rs.getFloat("dprice");
                int damount = rs.getInt("damount");
                OrderDetail orderDetail = new OrderDetail(_ono,dno,dprice,damount);

                orderDetails.add(orderDetail);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return orderDetails;
    }

}
