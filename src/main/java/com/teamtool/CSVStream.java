package com.teamtool;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVStream {

    public static void main(String[] args) { //should a 'throws' exception go on this line after args?
        ??? filepath? = ???.of("src", "main", "resources", "Employee.csv");

        Map<String, Long> employeeMap = ???.lines(path)
                .skip(1)
                .map(CSVStream::getEmployee)
                .collect(Collectors.groupingBy((Employee::getLastName), Collectors.counting()));
        System.out.println(employeeMap);

    }
    private static Employee getEmployee(String line) {
        String[] fields = line.split(",");
        if (fields.length!=#)
            throw new RuntimeException("Invalid CSV line - " + line);
        return new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], fields[4]);
    }
}


/*
***WHICH CLASS WOULD THE BELOW CODE BE PLACED IN:
*public class Car {
    private static String hiredate[};
    private static String name;
    private static String team;
    private final String job role;

    public **which java class goes here??** (String hiredate, String name, String team, String job role) {
        this.hired= hired;
        this.name = name;
        this.team = team;
        this.role = role;
    }

    public int getHireDate() {
        return hired;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getJobRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "hired=" + hired +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
*
 */