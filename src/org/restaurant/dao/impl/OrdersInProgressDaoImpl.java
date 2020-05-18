package org.restaurant.dao.impl;

import org.restaurant.dao.IOrdersInProgressDao;
import org.restaurant.entiey.OrdersInProgress;
import org.restaurant.service.IOrdersInProgressService;
import org.restaurant.service.impl.OrdersInProgressServiceImpl;
import org.restaurant.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersInProgressDaoImpl implements IOrdersInProgressDao {
    @Override
    public int getTotalCount(String sql) {
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public boolean addOrdersInProgress(OrdersInProgress ordersInProgress) {
        String sql = "insert into ordersInProgress(ono,bno,cost,diners) values (?,?,?,?)";
        Object[] params = {ordersInProgress.getOno(), ordersInProgress.getBno(), ordersInProgress.getCost(), ordersInProgress.getDiners()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean deleteOrdersInProgressByOno(String ono) {
        String sql = "delete from ordersInProgress where ono = ?";
        Object[] params = {ono};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean isExist(String ono) {
        return queryOrdersInProgressByOno(ono) == null ? false : true;
    }

    @Override
    public List<OrdersInProgress> queryOrdersInProgressByPage(int currentPage, int pageSize) {
        List<OrdersInProgress> ordersInProgresses = new ArrayList<>();

        String sql = "select * from ordersInProgress order by ono offset ?*? rows fetch next ? rows only";
        Object[] params = {currentPage-1,pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String _ono = rs.getString("ono");
                String _bno = rs.getString("bno");
                float cost = rs.getFloat("cost");
                int diners = rs.getInt("diners");
                OrdersInProgress ordersInProgress = new OrdersInProgress(_ono,_bno,cost,diners);

                ordersInProgresses.add(ordersInProgress);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return ordersInProgresses;
    }

    @Override
    public OrdersInProgress queryOrdersInProgressByOno(String ono) {
        ResultSet rs = null;
        OrdersInProgress ordersInProgress = null;

        try {

            String sql = "select * from ordersInProgress where ono = ?";
            Object[] params = {ono};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String _ono = rs.getString("ono");
                String _bno = rs.getString("bno");
                float cost = rs.getFloat("cost");
                int diners = rs.getInt("diners");
                ordersInProgress = new OrdersInProgress(_ono,_bno,cost,diners);

            }

            return ordersInProgress;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (DBUtil.con != null) DBUtil.con.close();
                return ordersInProgress;
            }catch (SQLException e){
                e.printStackTrace();
                return ordersInProgress;
            }
        }
    }

}
