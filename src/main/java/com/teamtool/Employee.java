package com.teamtool;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public abstract class Employee {

    public static String firstName;
    public static String lastName;
    static String notFound = "employee not found";
    static String fileName = "Employee.csv";

    static String[] employeeArray = new String[6];

    public Employee(){
        Employee.firstName= employeeArray[0];
        Employee.lastName = employeeArray[1];
    }


    public abstract void query();
}
