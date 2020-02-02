package edu.hbuas.examsystem.pojo;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer rrid;

    private Integer tid;

    private Integer rid;

    private String place;

    private String number;

    private Integer campus;

    private Integer storid;

    public Integer getRrid() {
        return rrid;
    }

    public void setRrid(Integer rrid) {
        this.rrid = rrid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getCampus() {
        return campus;
    }

    public void setCampus(Integer campus) {
        this.campus = campus;
    }

    public Integer getStorid() {
        return storid;
    }

    public void setStorid(Integer storid) {
        this.storid = storid;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rrid=" + rrid +
                ", tid=" + tid +
                ", rid=" + rid +
                ", place='" + place + '\'' +
                ", number='" + number + '\'' +
                ", campus=" + campus +
                ", storid=" + storid +
                '}';
    }
}