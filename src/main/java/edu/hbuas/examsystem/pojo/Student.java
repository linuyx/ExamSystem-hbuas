package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private String sid;

    private Integer tid;

    private String sname;

    private String sex;

    private String grade;

    private String clazz;

    private Integer pid;

    private Integer cid;

    private String idcard;

    private String photo;

    private Integer state;

}