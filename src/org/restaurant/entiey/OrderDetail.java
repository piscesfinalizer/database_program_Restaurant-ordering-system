package org.restaurant.entiey;

public class OrderDetail {
    private String ono;
    private String dno;
    private float dprice;
    private int damount;

    public OrderDetail(){

    }

    public OrderDetail(String ono, String dno, float dprice, int damount) {
        this.ono = ono;
        this.dno = dno;
        this.dprice = dprice;
        this.damount = damount;
    }

    public String getOno() {
        return ono;
    }

    public void setOno(String ono) {
        this.ono = ono;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public float getDprice() {
        return dprice;
    }

    public void setDprice(float dprice) {
        this.dprice = dprice;
    }

    public int getDamount() {
        return damount;
    }

    public void setDamount(int damount) {
        this.damount = damount;
    }
}
