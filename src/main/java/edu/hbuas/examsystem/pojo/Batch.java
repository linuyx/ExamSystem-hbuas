package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch implements Serializable {

    private Integer bid;

    private String type;

    private String grade;

    private String bname;

    private Integer tid;

    private String pbatch;


}