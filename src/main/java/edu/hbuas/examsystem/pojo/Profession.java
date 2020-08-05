package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profession implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer cid;

    private String pname;

}