package org.restaurant.entiey;

public class Dish {
    private String dno;
    private String dname;
    private String dimgpath;
    private float dprice;
    private float dweight;
    private int dsold;
    private int num;

    public Dish(){

    }

    public Dish(String dno, String dname, String dimgpath, float dprice, float dweight, int dsold) {
        this.dno = dno.trim();
        this.dname = dname.trim();
        this.dimgpath = dimgpath.trim();
        this.dprice = dprice;
        this.dweight = dweight;
        this.dsold = dsold;
        num = 0;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDimgpath() {
        return dimgpath;
    }

    public void setDimgpath(String dimgpath) {
        this.dimgpath = dimgpath;
    }

    public float getDprice() {
        return dprice;
    }

    public void setDprice(float dprice) {
        this.dprice = dprice;
    }

    public float getDweight() {
        return dweight;
    }

    public void setDweight(float dweight) {
        this.dweight = dweight;
    }

    public int getDsold() {
        return dsold;
    }

    public void setDsold(int dsold) {
        this.dsold = dsold;
    }

    public void addNum(){
        num++;
    }

    public void reduceNum(){
        if (num > 0)
            num--;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                ", dimgpath='" + dimgpath + '\'' +
                ", dprice=" + dprice +
                ", dweight=" + dweight +
                ", dsold=" + dsold +
                ", num=" + num +
                '}';
    }
}
