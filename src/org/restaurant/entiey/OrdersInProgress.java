package org.restaurant.entiey;

public class OrdersInProgress {
    private String ono;
    private String bno;
    private float cost;
    private int diners;

    public OrdersInProgress(){

    }

    public OrdersInProgress(String ono, String bno, float cost, int diners) {
        this.ono = ono;
        this.bno = bno;
        this.cost = cost;
        this.diners = diners;
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

    public int getDiners() {
        return diners;
    }

    public void setDiners(int diners) {
        this.diners = diners;
    }

    @Override
    public String toString() {
        return "OrdersInProgress{" +
                "ono='" + ono + '\'' +
                ", bno='" + bno + '\'' +
                ", cost=" + cost +
                ", diners=" + diners +
                '}';
    }
}
