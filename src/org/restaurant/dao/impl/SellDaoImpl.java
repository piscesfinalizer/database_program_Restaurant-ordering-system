package org.restaurant.dao.impl;

import org.restaurant.dao.ISellDao;
import org.restaurant.entiey.Sell;
import org.restaurant.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellDaoImpl implements ISellDao {
    @Override
    public int getTotalCount(String sql) {
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public boolean addSell(Sell sell) {
        String sql = "insert into sellSituation(dates,turnover) values (?,?)";
        Object[] params = {sell.getDates(),sell.getTurnover()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean isExist(String dates) {
        return querySellByDates(dates) == null ? false : true;
    }

    @Override
    public List<Sell> querySellsByPage(int currentPage, int pageSize) {
        List<Sell> sells = new ArrayList<>();

        String sql = "select * from sellSituation order by dates offset ?*? rows fetch next ? rows only";
        Object[] params = {currentPage-1,pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String date = rs.getString("dates");
                Float turnover = Float.parseFloat(rs.getString("turnover"));
                Sell sell = new Sell(date,turnover);
                sells.add(sell);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return sells;
    }

    @Override
    public Sell querySellByDates(String dates) {
        ResultSet rs = null;
        Sell sell = null;

        try {

            String sql = "select * from sellSituation where dates = ?";
            Object[] params = {dates};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String date = rs.getString("dates");
                Float turnover = Float.parseFloat(rs.getString("turnover"));
                sell = new Sell(date,turnover);

            }

            return sell;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (DBUtil.con != null) DBUtil.con.close();
                return sell;
            }catch (SQLException e){
                e.printStackTrace();
                return sell;
            }
        }
    }
}
