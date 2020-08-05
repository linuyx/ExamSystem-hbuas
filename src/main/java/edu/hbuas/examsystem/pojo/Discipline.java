package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discipline implements Serializable {
    private Integer id;

    private Integer disid;

    private String sid;

    private String place;

    private String subjects;

    private String dateof;

    private Date addtime;

    private Integer reason;

    private String note;

    private Integer totaltime;

}