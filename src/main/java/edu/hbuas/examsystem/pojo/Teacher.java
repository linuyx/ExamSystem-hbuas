package edu.hbuas.examsystem.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Teacher implements Serializable {
    private Integer tid;

    private String number;

    private String tname;

    private String sex;

    private String wages;

    private String phone;

    private Integer cid;

    private Integer rid;

    private Integer times;

    private String college;

    private String rname;

    private boolean flag;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages == null ? null : wages.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", number='" + number + '\'' +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                ", wages='" + wages + '\'' +
                ", phone='" + phone + '\'' +
                ", cid=" + cid +
                ", rid=" + rid +
                ", times=" + times +
                ", college='" + college + '\'' +
                ", rname='" + rname + '\'' +
                ", flag=" + flag +
                '}';
    }

    public boolean sjk(Teacher teacher1,Teacher teacher2){
        if(teacher1.getNumber()==teacher2.getNumber()){
            return true;
        }else {
            return false;
        }
    }
}