package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Degree implements Serializable {

    private Integer sid;

    private Integer tid;

    private String name;

    private String sex;

    private String level;

    private String clazz;

    private Integer pid;

    private Integer cid;

    private String grade;

    private String phone;

}