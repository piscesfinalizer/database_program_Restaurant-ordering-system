package org.restaurant.util;

import java.sql.*;


//通用的数据库操作方法，减少dao层代码量
//方法重构:提炼共同代码,单独写在一个方法中，然后引入该方法即可
public class DBUtil {
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //指定SQLserver JDBC驱动程序
    private static final String usel = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=restaurantOrderingSystem";
    private static final String user = "sa";
    private static final String password = "123456";
    public static Connection con = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    //查询总数
    public static int getTotalCount(String sql){
        int count = -1;
        try {
            pstmt = createPreparedStatement(sql,null);
            rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(rs,pstmt,con);
        }
        return count;
    }

    //通用的增删改
    public static boolean executeUpdate(String sql,Object[] params){
        int count = -1;
        try {
            pstmt = createPreparedStatement(sql, params);
            count = pstmt.executeUpdate();

            if(count>0){
                return true;
            }else {
                return false;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(null,pstmt,con);
            return count>0;
        }
    }

    public static void closeAll(ResultSet rs,Statement stmt, Connection con){
        try {
            if (rs!=null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();

        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
        pstmt = getConnection().prepareStatement(sql);
        if(params!=null){
            for (int i = 0; i < params.length; i++){
                pstmt.setObject(i+1,params[i]);
            }
        }
        return pstmt;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(usel,user,password);
    }

    //通用的查:适合任何查询
    public static ResultSet executeQuery(String sql,Object[] params){
        try {

            pstmt = createPreparedStatement(sql,params);
            rs = pstmt.executeQuery();

            return rs;

        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return rs;
        }

    }
}
