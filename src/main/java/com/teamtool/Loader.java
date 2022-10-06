package com.teamtool;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Loader {

    public List<String[]> loadEmployees (String fileName) throws URISyntaxException, IOException {
        URI uri = Loader.class
                .getClassLoader()
                .getResource("Employee.csv")
                .toURI();
        Path path = Path.of(uri);


        return Files.lines(path)
                .skip(1)
                .map(String::trim)
                .filter((line) -> !line.isEmpty())
                .map((line) -> line.split("\\s*,\\s*"))
                .collect(Collectors.toList());
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