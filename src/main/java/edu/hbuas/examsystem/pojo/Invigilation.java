package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invigilation implements Serializable {
    private Integer id;

    private Integer tid;

    private Integer cid;

    private String number;

}