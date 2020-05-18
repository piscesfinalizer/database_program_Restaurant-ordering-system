package org.restaurant.dao.impl;

import org.restaurant.dao.IOrdersFinishedDao;
import org.restaurant.entiey.OrdersFinished;
import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdersFinishedDaoImpl implements IOrdersFinishedDao {
    @Override
    public int getTotalCount(String sql) {
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public List<OrdersFinished> queryOrdersFinishedByPage(int currentPage, int pageSize) {
        List<OrdersFinished> ordersFinisheds = new ArrayList<>();

        String sql = "select * from finishedOrders order by ono offset ?*? rows fetch next ? rows only";
        Object[] params = {currentPage-1,pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String _ono = rs.getString("ono");
                String _bno = rs.getString("bno");
                float cost = rs.getFloat("cost");
                String cphone = rs.getString("cphone");
                String payway = rs.getString("payway");
                Timestamp checktime = rs.getTimestamp("checktime");

                OrdersFinished ordersFinished = new OrdersFinished(_ono,_bno,cost,cphone,payway,checktime);

                ordersFinisheds.add(ordersFinished);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return ordersFinisheds;
    }

    @Override
    public boolean addOrdersFinished(OrdersFinished ordersFinished) {
        String sql = "insert into finishedOrders(ono,bno,cost,cphone,payway,checktime) values (?,?,?,?,?,?)";
        Object[] params = {ordersFinished.getOno(),ordersFinished.getBno(),ordersFinished.getCost(),ordersFinished.getCphone(),ordersFinished.getPayway(),ordersFinished.getChecktime()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean isExist(String ono) {
        return queryOrdersFinishedByOno(ono) == null ? false : true;
    }

    @Override
    public OrdersFinished queryOrdersFinishedByOno(String ono) {
        ResultSet rs = null;
        OrdersFinished ordersFinished = null;

        try {

            String sql = "select * from finishedOrders where ono = ?";
            Object[] params = {ono};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String _ono = rs.getString("ono");
                String _bno = rs.getString("bno");
                float cost = rs.getFloat("cost");
                String cphone = rs.getString("cphone");
                String payway = rs.getString("payway");
                Timestamp checktime = rs.getTimestamp("checktime");
                ordersFinished = new OrdersFinished(_ono,_bno,cost,cphone,payway,checktime);

            }

            return ordersFinished;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (DBUtil.con != null) DBUtil.con.close();
                return ordersFinished;
            }catch (SQLException e){
                e.printStackTrace();
                return ordersFinished;
            }
        }
    }

}
