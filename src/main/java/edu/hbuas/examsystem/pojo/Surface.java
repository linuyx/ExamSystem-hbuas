package edu.hbuas.examsystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class Surface implements Serializable {
    private Integer suid;

    private String teacher;

    private Integer eid;

    private Integer tid;

    private Integer rid;

    private String testtime;

    private String begin;

    private String end;

    private String worknumber;

    private Integer number;

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
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

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(String worknumber) {
        this.worknumber = worknumber == null ? null : worknumber.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Surface{" +
                "suid=" + suid +
                ", teacher='" + teacher + '\'' +
                ", eid=" + eid +
                ", tid=" + tid +
                ", rid=" + rid +
                ", testtime=" + testtime +
                ", begin=" + begin +
                ", end=" + end +
                ", worknumber='" + worknumber + '\'' +
                ", number=" + number +
                '}';
    }
}