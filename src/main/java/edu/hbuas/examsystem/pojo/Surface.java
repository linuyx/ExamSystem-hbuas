package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}