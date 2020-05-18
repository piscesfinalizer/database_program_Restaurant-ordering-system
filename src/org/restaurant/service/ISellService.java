package org.restaurant.service;

import org.restaurant.entiey.Sell;

import java.util.List;

public interface ISellService {
    public List<Sell> querySellsByPage(int currentPage, int pageSize);

    public int getTotalCount();

    public boolean addSell(Sell sell);
}
