package edu.hbuas.examsystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class Examtime implements Serializable {
    private Integer eeid;

    private Integer tid;

    private Date edate;

    public Integer getEeid() {
        return eeid;
    }

    public void setEeid(Integer eeid) {
        this.eeid = eeid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }
}