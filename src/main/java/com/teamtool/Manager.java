package com.teamtool;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Manager extends Employee{

    static String notFound = "employee not found";
    static String fileName = "Employee.csv";
    private static String[] employeeArray = new String[6];
    public Manager() {
        super();
    }



    public static void query() {
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
                    String[] employeeArray = line.split(",");
                    String firstName = employeeArray[0];
                    String lastName = employeeArray[1];
                    String hireDate = employeeArray[2];
                    String team = employeeArray[3];
                    String role = employeeArray[4];
                    String managerStatus = employeeArray[5];
                    result = String.format("\nfirst-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s\n", firstName, lastName, hireDate, team, role, managerStatus);
                    Manager.employeeArray = employeeArray;
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
            ///test
    public static void addEmployee() {

        Scanner input = new Scanner(System.in);
        System.out.println("please enter first name");
        String firstName = input.nextLine();
        System.out.println("please enter last name");
        String lastName = input.nextLine();
        System.out.println("please enter a hire date");
        String hireDate = input.nextLine();
        System.out.println("please enter a team");
        String team = input.nextLine();
        System.out.println("please enter a role");
        String role = input.nextLine();
        System.out.println("is this employee a manager");
        String managerStatus = input.nextLine();
        System.out.printf("first-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s", firstName, lastName, hireDate, team, role, managerStatus);
        try {
            FileWriter fw =new FileWriter("Employee.csv", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.newLine();
            writer.write(String.format("%s,%s,%s,%s,%s,%s", firstName, lastName, hireDate, team, role, managerStatus));
            writer.close();
            } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void changeEmployee() {
        query();
        Scanner in = new Scanner(System.in);
        System.out.println("\nwhat do you want to change enter 0:first-name, 1:last-name, 2:hireDate, 3:team, 4:role, 5:managerStatus");
        int test = in.nextInt();
        in.nextLine();
        System.out.println("enter desired change");
        String change = in.nextLine();
        employeeArray[test] = change;
        System.out.println(Arrays.toString(employeeArray));
    }

    void deleteEmployee() {
        query();
        Scanner in = new Scanner(System.in);
        System.out.println("\nwhat do you want to change enter 0:first-name, 1:last-name, 2:hireDate, 3:team, 4:role, 5:managerStatus");
        int test = in.nextInt();
        in.nextLine();

    }
}
