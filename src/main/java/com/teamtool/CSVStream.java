package com.teamtool;


import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVStream {

    public static void main(String[] args) throws URISyntaxException { //should a 'throws' exception go on this line after args?
        URI uri = CSVStream.class
                .getClassLoader()
                .getResource("Employee.csv")
                .toURI();
        Path path = Path.of(uri);


        Map<String, List<Employee>> employeeMap = Files.lines(path)
                .skip(1)
                .map(CSVStream::getEmployee)
                .collect(Collectors.groupingBy((Employee::getLastName), Collectors.toList()));
        System.out.println(employeeMap);

    }
    private static Employee getEmployee(String line) {
        String[] fields = line.split("\\s*,\\s*");
        if (fields.length!=5) {
            throw new RuntimeException("Invalid CSV line - " + line);
        }
//        return new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], fields[4]);
        return null;
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