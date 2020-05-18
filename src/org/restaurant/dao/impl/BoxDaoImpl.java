package org.restaurant.dao.impl;

import org.restaurant.dao.IBoxDao;
import org.restaurant.entiey.Box;
import org.restaurant.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoxDaoImpl implements IBoxDao {

    @Override
    public List<Box> queryAllBoxes() {
        List<Box> boxes = new ArrayList<>();
        ResultSet rs = null;

        try {
            String sql = "select * from box";
            rs = DBUtil.executeQuery(sql,null);

            while(rs.next()){
                String no = rs.getString("bno");
                String name = rs.getString("bname");
                int capacity = rs.getInt("bcapacity");
                String state = rs.getString("bstate");
                Box box = new Box(no,name,capacity,state);
                boxes.add(box);
            }
            return boxes;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(rs,null,DBUtil.con);
            return boxes;
        }
    }


    @Override
    public List<Box> queryBoxesByPage(int currentPage, int pageSize) {
        List<Box> boxes = new ArrayList<>();

        String sql = "select * from box order by bno offset ?*? rows fetch next ? rows only";
        Object[] params = {currentPage-1,pageSize,pageSize};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            while(rs.next()){
                String no = rs.getString("bno");
                String name = rs.getString("bname");
                int capacity = rs.getInt("bcapacity");
                String state = rs.getString("bstate");
                Box box = new Box(no,name,capacity,state);
                boxes.add(box);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return boxes;
    }

    @Override
    public int getTotalCount(String sql) {
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public Box queryBoxByBno(String bno) {
        ResultSet rs = null;
        Box box = null;

        try {

            String sql = "select * from box where bno = ?";
            Object[] params = {bno};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String no = rs.getString("bno");
                String name = rs.getString("bname");
                int capacity = rs.getInt("bcapacity");
                String state = rs.getString("bstate");
                box = new Box(no,name,capacity,state);

            }

            return box;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (DBUtil.con != null) DBUtil.con.close();
                return box;
            }catch (SQLException e){
                e.printStackTrace();
                return box;
            }
        }
    }

    @Override
    public boolean isExist(String bno) {
        return queryBoxByBno(bno) == null ? false : true;
    }

    @Override
    public boolean addBox(Box box) {
        String sql = "insert into box(bno,bname,bcapacity,bstate) values (?,?,?,?)";
        Object[] params = {box.getBno(),box.getBname(),box.getBcapacity(),box.getBstate()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public Box queryAppropriateBoxes(int diners) {
        ResultSet rs = null;
        Box box = null;

        try {

            String sql = "select top 1 * from box where bcapacity >= ? and bstate = '空闲' order by bcapacity asc";
            Object[] params = {diners};
            rs = DBUtil.executeQuery(sql,params);

            if(rs.next()){
                String no = rs.getString("bno");
                String name = rs.getString("bname");
                int capacity = rs.getInt("bcapacity");
                String state = rs.getString("bstate");
                box = new Box(no,name,capacity,state);

            }

            return box;

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (DBUtil.con != null) DBUtil.con.close();
                return box;
            }catch (SQLException e){
                e.printStackTrace();
                return box;
            }
        }
    }
}
