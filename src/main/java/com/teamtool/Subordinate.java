package com.teamtool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static com.teamtool.Login.fileName;

public class Subordinate extends Employee {

    public Subordinate() {
        super();
    }

    @Override
    public void query() {
        String result = "employee not found";
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter employee name");
        String findEmployee = in.nextLine();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(findEmployee)) {
                    String[] employeeArray = line.split(",");
                    String firstName = employeeArray[0];
                    String lastName = employeeArray[1];
                    String team = employeeArray[3];
                    String role = employeeArray[4];
                    result = String.format("\nfirst-name:%s, last-name:%s, team:%s, role:%s\n", firstName, lastName, team, role);
                    Login.employeeArray = employeeArray;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }

    public void queryTeam() {
        String result = "team not found";
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter team name");
        String findTeam = in.nextLine();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            StringBuilder s = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.contains(findTeam)) {
                    s.append(line);
                    s.append("\n");
                }
            }
            reader.close();
            result = s.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }
}
