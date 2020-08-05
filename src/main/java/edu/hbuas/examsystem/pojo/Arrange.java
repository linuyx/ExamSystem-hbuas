package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arrange implements Serializable {

    private Integer aid;

    private Integer tid;

    private String sid;

    private Integer eid;

    private Integer reset;


}