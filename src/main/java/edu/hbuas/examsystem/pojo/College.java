package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class College implements Serializable {

    private Integer id;

    private Integer cid;

    private String college;

    private String collegeOld;

    private boolean flag;


}