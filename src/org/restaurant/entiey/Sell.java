package org.restaurant.entiey;

public class Sell {
    private float turnover;
    private String dates;

    public Sell(String dates,float turnover) {
        this.turnover = turnover;
        this.dates = dates.trim();
    }
    public Sell(){

    }

    public float getTurnover() {
        return turnover;
    }

    public void setTurnover(float turnover) {
        this.turnover = turnover;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
}
