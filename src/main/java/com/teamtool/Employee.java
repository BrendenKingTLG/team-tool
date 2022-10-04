package com.teamtool;

import java.time.LocalDate;

public class Employee {

    //instance variables
    public String firstName;
    public String lastName;
    public LocalDate hireDate;  // TODO: 10/3/2022 should this be a String or int?
    public String team;  // TODO: 10/3/2022 Should this be an enum?
    public String role;  // TODO: 10/3/2022 Should this be an enum?
    public Boolean isManager;  //

    public Employee(String firstName, String lastName, LocalDate hireDate, String team, String role, Boolean isManager){
        setFirstName(firstName);
        setLastName(lastName);
        setHireDate(hireDate);
        setTeam(team);
        setRole(role);
        setManager(isManager);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public Boolean getManager() {
        return isManager;
    }
}
