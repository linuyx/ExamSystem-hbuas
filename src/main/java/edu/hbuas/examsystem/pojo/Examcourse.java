package edu.hbuas.examsystem.pojo;

import java.io.Serializable;

public class Examcourse implements Serializable {
    private Integer eid;

    private Integer tid;

    private Integer cid;

    private Integer pid;

    private String grade;

    private String clazz;

    private String name;

    private Integer number;

    private Integer resetNumber;

    private Integer total;

    private String testForm;

    private Integer priority;

    private Integer accomplish;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getResetNumber() {
        return resetNumber;
    }

    public void setResetNumber(Integer resetNumber) {
        this.resetNumber = resetNumber;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTestForm() {
        return testForm;
    }

    public void setTestForm(String testForm) {
        this.testForm = testForm == null ? null : testForm.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getAccomplish() {
        return accomplish;
    }

    public void setAccomplish(Integer accomplish) {
        this.accomplish = accomplish;
    }
}