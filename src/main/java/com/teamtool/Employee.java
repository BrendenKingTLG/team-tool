package com.teamtool;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Employee {

    private static int ID = 0;
    private String name;
    private LocalDate hiredate;

    public Employee(String name, LocalDate hiredate){
        ID++;
        this.name=name;
        this.hiredate=hiredate;
    }


}
