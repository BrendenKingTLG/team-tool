package com.teamtool;

import java.time.LocalDate;

public class Subordinate extends Employee{

    public Subordinate(String name, LocalDate hiredate) {
        super(name, hiredate);
    }

    @Override
    void query() {

    }
}
