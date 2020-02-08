package edu.hbuas.examsystem.pojo;

import java.io.Serializable;

public class College implements Serializable {
    private Integer id;

    private Integer cid;

    private String college;

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
        this.college = college == null ? null : college.trim();
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", cid=" + cid +
                ", college='" + college + '\'' +
                '}';
    }
}