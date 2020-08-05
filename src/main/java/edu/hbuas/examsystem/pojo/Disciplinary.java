package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplinary implements Serializable {
    private Integer id;

    private Integer did;

    private String type;

    private String distype;

    private Integer time;

}