package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable {
    private Integer rrid;

    private Integer tid;

    private Integer rid;

    private String place;

    private String number;

    private Integer campus;

    private Integer storid;

}