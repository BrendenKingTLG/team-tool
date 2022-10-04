package com.teamtool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Subordinate extends Employee{

    private static String hireDate;
    private static String team;
    private static String role;

    public Subordinate(String firstName, String lastName, String hireDate, String team, String role) {
        super();
        Subordinate.hireDate = hireDate;
        Subordinate.team = team;
        Subordinate.role = role;
    }

    @Override
    public void query() {
        String result = notFound;
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter employee name");
        String findEmployee = in.nextLine();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(findEmployee)) {
                    employeeArray = line.split(",");
                    firstName = employeeArray[0];
                    lastName = employeeArray[1];
                    hireDate = employeeArray[2];
                    team = employeeArray[3];
                    role = employeeArray[4];
                    System.out.println(Arrays.toString(employeeArray));
                    result = String.format("\nfirst-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s\n", firstName, lastName, hireDate, team, role);
                } else {
                    System.out.println("searching...");
                }
            }
            reader.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}
