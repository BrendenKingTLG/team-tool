package com.teamtool;

import java.time.LocalDate;

public abstract class Employee {

    private static int ID = 0;
    private String name;
    private LocalDate hiredate;

    public Employee(String name, LocalDate hiredate){
        ID++;
        this.name=name;
        this.hiredate=hiredate;
    }


    abstract void query();

}
