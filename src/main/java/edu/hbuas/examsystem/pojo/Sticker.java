package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sticker implements Serializable {
    private Integer id;

    private String eid;

    private Integer suid;

    private Integer tid;

    private String ename;

    private String clazz;

}