package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details implements Serializable {
    private Integer did;

    private Integer suid;

    private String sid;

    private String sname;

    private String sex;

    private String pname;

    private Integer tid;

    private String name;

    private Integer eid;

    private Date examtime;

    private String place;

    private Date begin;

    private Date end;

    private String seat;

    private Integer rid;

}