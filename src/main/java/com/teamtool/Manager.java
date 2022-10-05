package com.teamtool;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


import static com.teamtool.Login.*;

public class Manager extends Employee {
    private static String firstName;
    private static String lastName;
    private static String hireDate;
    private static String team;
    private static String role;
    private static String managerStatus;

    public Manager() {
        super();
    }

    @Override
    public void query() {
        String result = "employee not found";
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter employee name");
        String findEmployee = in.nextLine().toLowerCase();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(findEmployee)) {
                    String[] employeeArray = line.split(",");
                    firstName = employeeArray[0];
                    lastName = employeeArray[1];
                    hireDate = employeeArray[2];
                    team = employeeArray[3];
                    role = employeeArray[4];
                    managerStatus = employeeArray[5];
                    result = String.format("\nfirst-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s, is-manager:%s\n", firstName, lastName, hireDate, team, role, managerStatus);
                    Login.employeeArray = employeeArray;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
    }

    public void addEmployee() {
        getUserInput();
        System.out.printf("first-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s", firstName, lastName, hireDate, team, role, managerStatus);
        try (FileWriter fw = new FileWriter("Employee.csv", true);
             BufferedWriter writer = new BufferedWriter(fw)) {
                writer.newLine();
                writer.write(String.format("%s,%s,%s,%s,%s,%s", firstName, lastName, hireDate, team, role, managerStatus));
                System.out.println("\nemployee created");
        } catch (Exception e) {
            e.printStackTrace();
        }
        startApp();

    }

    public void changeEmployee() {
        query();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(employeeArray[0]))
                    str.append(line);
                str.append("\n");
            }
            Scanner in = new Scanner(System.in);
            System.out.println("\nwhat do you want to change enter 0:first-name, 1:last-name, 2:hireDate, 3:team, 4:role, 5:managerStatus");
            int test = in.nextInt();
            in.nextLine();
            System.out.println("enter desired change");
            String change = in.nextLine().toLowerCase();
            employeeArray[test] = change;
            System.out.println(Arrays.toString(employeeArray));
            PrintWriter writer = new PrintWriter(fileName);
            String sb = Arrays.toString(employeeArray);
            sb = sb.replace("[", "");
            sb = sb.replace("]", "");
            sb = sb.replaceAll("\\s+", "");
            str.append(sb);
            writer.write(String.valueOf(str));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startApp();
    }

    public void deleteEmployee() {
        query();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(employeeArray[0]))
                    str.append(line);
                str.append("\n");
            }
            PrintWriter writer = new PrintWriter(fileName);
            writer.print(str);
            writer.close();
            System.out.println("\nemployee deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
        startApp();

    }

    public void getUserInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("please enter first name");
        firstName = input.nextLine().toLowerCase();
        System.out.println("please enter last name");
        lastName = input.nextLine().toLowerCase();
        System.out.println("please enter a hire date format: YYYY-MM-DD");
        hireDate = input.nextLine();
        while (!hireDate.matches("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println("please enter correct format ex:YYYY-MM-DD");
            hireDate = input.nextLine();
        }
        System.out.println("please enter a team");
        team = input.nextLine().toLowerCase();
        System.out.println("please enter a role");
        role = input.nextLine().toLowerCase();
        System.out.println("is this employee a manager");
        managerStatus = input.nextLine().toLowerCase();
    }

}
