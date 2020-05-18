package org.restaurant.dao.impl;

import org.restaurant.dao.IDishDao;
import org.restaurant.entiey.Dish;
import org.restaurant.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements IDishDao {
    @Override
    public List<Dish> queryDishesByPage(int currentPage, int pageSize) {
        List<Dish> dishes = new ArrayList<>();

        String sql = "select * from mainDishes order by dno offset ?*? rows fetch next ? rows only";
        Object[] params = {currentPage-1,pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String no = rs.getString("dno");
                String name = rs.getString("dname");
                String imgpath = rs.getString("dimgpath");
                float price = rs.getFloat("dprice");
                float weight = rs.getFloat("dweight");
                int sold = rs.getInt("dsold");
                Dish dish = new Dish(no,name,imgpath,price,weight,sold);

                dishes.add(dish);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return dishes;
    }

    @Override
    public int getTotalCount(String sql) {
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public Dish queryDishByDno(String dno) {
        ResultSet rs = null;
        Dish dish = null;

        try {

            String sql = "select * from mainDishes where dno = ?";
            Object[] params = {dno};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String no = rs.getString("dno");
                String name = rs.getString("dname");
                String imgpath = rs.getString("dimgpath");
                float price = rs.getFloat("dprice");
                float weight = rs.getFloat("dweight");
                int sold = rs.getInt("dsold");

                dish = new Dish(no,name,imgpath,price,weight,sold);

            }

            return dish;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (DBUtil.con != null) DBUtil.con.close();
                return dish;
            }catch (SQLException e){
                e.printStackTrace();
                return dish;
            }
        }
    }

    @Override
    public boolean isExist(String dno) {
        return queryDishByDno(dno) == null ? false : true;
    }

    @Override
    public boolean addDish(Dish dish) {
        String sql = "insert into mainDishes(dno,dname,dimgpath,dprice,dweight,dsold) values (?,?,?,?,?,?)";
        Object[] params = {dish.getDno(),dish.getDname(),dish.getDimgpath(),dish.getDprice(),dish.getDweight(),dish.getDsold()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean updateDishByDno(String dno, Dish dish) {
        String sql = "update mainDishes set dname = ?,dimgpath = ?, dprice = ?,dweight = ?,dsold = ? where dno = ?";
        Object[] params = {dish.getDname(),dish.getDimgpath(),dish.getDprice(),dish.getDweight(),dish.getDsold(),dish.getDno()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean deleteDishByDno(String dno) {
        String sql = "delete from mainDishes where dno = ?";
        Object[] params = {dno};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public List<Dish> queryAllDishes() {
        List<Dish> dishes = new ArrayList<>();

        String sql = "select * from mainDishes";
        ResultSet rs = DBUtil.executeQuery(sql,null);
        try {
            while(rs.next()){
                String no = rs.getString("dno");
                String name = rs.getString("dname");
                String imgpath = rs.getString("dimgpath");
                float price = rs.getFloat("dprice");
                float weight = rs.getFloat("dweight");
                int sold = rs.getInt("dsold");
                Dish dish = new Dish(no,name,imgpath,price,weight,sold);

                dishes.add(dish);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return dishes;
    }
}
