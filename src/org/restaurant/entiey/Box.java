package org.restaurant.entiey;

public class Box {
    private String bno;
    private String bname;
    private int bcapacity;
    private String bstate;

    public Box(){

    }

    public Box(String bno, String bname, int bcapacity, String bstate) {
        this.bno = bno.trim();
        this.bname = bname.trim();
        this.bcapacity = bcapacity;
        this.bstate = bstate.trim();
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getBcapacity() {
        return bcapacity;
    }

    public void setBcapacity(int bcapacity) {
        this.bcapacity = bcapacity;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

}
