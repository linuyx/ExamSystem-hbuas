package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taskplan implements Serializable {
    private Integer tid;

    private Date begin;

    private Date end;

    private String type;

    private String description;

    private String state;

    private String cid;

    private Integer times;

}