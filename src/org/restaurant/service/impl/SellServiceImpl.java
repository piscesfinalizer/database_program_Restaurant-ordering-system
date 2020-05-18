package org.restaurant.service.impl;

import org.restaurant.dao.ISellDao;
import org.restaurant.dao.impl.SellDaoImpl;
import org.restaurant.entiey.Sell;
import org.restaurant.service.ISellService;

import java.util.List;

public class SellServiceImpl implements ISellService {
    ISellDao sellDao = new SellDaoImpl();

    @Override
    public List<Sell> querySellsByPage(int currentPage, int pageSize) {
        return sellDao.querySellsByPage(currentPage,pageSize);
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from sellSituation";
        return sellDao.getTotalCount(sql);
    }

    @Override
    public boolean addSell(Sell sell) {
        if(!sellDao.isExist(sell.getDates())){//不存在
            return sellDao.addSell(sell);
        }else {
            System.out.println("此营收记录已存在！");
            return false;
        }
    }
}
