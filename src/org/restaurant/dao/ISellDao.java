package org.restaurant.dao;



import org.restaurant.entiey.Sell;

import java.util.List;

public interface ISellDao {
    public int getTotalCount(String sql);//查询总数据的条数

    public boolean addSell(Sell sell);

    public boolean isExist(String dates);

    public List<Sell> querySellsByPage(int currentPage, int pageSize);

    public Sell querySellByDates(String dates);
}
