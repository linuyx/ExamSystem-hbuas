package edu.hbuas.examsystem.pojo;

import java.io.Serializable;

public class College implements Serializable {
    private Integer id;

    private Integer cid;

    private String college;

    private boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", cid=" + cid +
                ", college='" + college + '\'' +
                ", flag=" + flag +
                '}';
    }
}