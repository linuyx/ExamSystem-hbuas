package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examdate implements Serializable {
    private Integer ttid;

    private Integer tid;

    private Integer eid;

    private Date etime;

}