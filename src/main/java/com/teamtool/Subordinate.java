package com.teamtool;

import java.time.LocalDate;

public class Subordinate extends Employee{

    public Subordinate(String firstName, String lastName, LocalDate hireDate, String team, String role, Boolean isManager) {
        super(firstName, lastName, hireDate, team, role, isManager);
    }

    void query() {

    }
}
