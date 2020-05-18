package org.restaurant.service.impl;

import org.restaurant.dao.IBoxDao;
import org.restaurant.dao.impl.BoxDaoImpl;
import org.restaurant.entiey.Box;
import org.restaurant.service.IBoxService;

import java.util.List;

public class BoxServiceImpl implements IBoxService {
    IBoxDao boxDao = new BoxDaoImpl();

    @Override
    public List<Box> queryAllBoxes() {
        return boxDao.queryAllBoxes();
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(1) from box";
        return boxDao.getTotalCount(sql);
    }

    @Override
    public List<Box> queryBoxesByPage(int currentPage, int pageSize) {
        return boxDao.queryBoxesByPage(currentPage,pageSize);
    }

    @Override
    public boolean addBox(Box box) {
        if(!boxDao.isExist(box.getBno())){//不存在
            return boxDao.addBox(box);
        }else {
            System.out.println("此包厢已存在！");
            return false;
        }
    }

    @Override
    public Box queryAppropriateBoxes(int diners) {
        return boxDao.queryAppropriateBoxes(diners);
    }
}
