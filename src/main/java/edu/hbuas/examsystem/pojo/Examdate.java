package edu.hbuas.examsystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class Examdate implements Serializable {
    private Integer ttid;

    private Integer tid;

    private Integer eid;

    private Date etime;

    public Integer getTtid() {
        return ttid;
    }

    public void setTtid(Integer ttid) {
        this.ttid = ttid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }
}