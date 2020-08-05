package edu.hbuas.examsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    private Integer tid;

    private String number;

    private String tname;

    private String sex;

    private String wages;

    private String phone;

    private Integer cid;

    private Integer rid;

    private Integer times;

    private String college;

    private String rname;

    private boolean flag;


    public boolean sjk(Teacher teacher1,Teacher teacher2){
        if(teacher1.getNumber()==teacher2.getNumber()){
            return true;
        }else {
            return false;
        }
    }
}