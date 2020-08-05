package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}