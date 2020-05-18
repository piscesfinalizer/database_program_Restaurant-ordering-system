package org.restaurant.entiey;

import java.sql.Timestamp;

public class OrdersFinished {
    private String ono;
    private String bno;
    private float cost;
    private String cphone;
    private String payway;
    private Timestamp checktime;

    public OrdersFinished(){

    }

    public OrdersFinished(String ono, String bno, float cost, String cphone, String payway, Timestamp checktime) {
        this.ono = ono;
        this.bno = bno;
        this.cost = cost;
        this.cphone = cphone;
        this.payway = payway;
        this.checktime = checktime;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public Timestamp getChecktime() {
        return checktime;
    }

    public void setChecktime(Timestamp checktime) {
        this.checktime = checktime;
    }

    @Override
    public String toString() {
        return "OrdersFinished{" +
                "ono='" + ono + '\'' +
                ", bno='" + bno + '\'' +
                ", cost=" + cost +
                ", cphone='" + cphone + '\'' +
                ", payway='" + payway + '\'' +
                ", checktime=" + checktime +
                '}';
    }
}
