package com.teamtool;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Manager extends Employee{

    public static String hireDate;
    public static String team;
    public static String role;
    public static String isManager;

    public Manager() {
        super();
    }

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
                    isManager = employeeArray[5];
                    System.out.println(Arrays.toString(employeeArray));
                    result = String.format("\nfirst-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s\n", firstName, lastName, hireDate, team, role, isManager);
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

    public void changeEmployee() {
        query();
        Scanner in = new Scanner(System.in);
        System.out.println("\nwhat do you want to change enter 0:first-name, 1:last-name, 2:hireDate, 3:team, 4:role, 5:managerStatus");
        int test = in.nextInt();
        in.nextLine();
        System.out.println("enter desired change");
        String change = in.nextLine();
        employeeArray[test] = change;
        try(BufferedWriter writer= new BufferedWriter(new FileWriter("Employee.csv", true))){
            writer.newLine();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(employeeArray));
    }

    void deleteEmployee() {
        query();
        StringBuilder stringBuilder = new StringBuilder();
        Scanner in = new Scanner(System.in);
        System.out.println("\nwhat do you want to change enter 0:first-name, 1:last-name, 2:hireDate, 3:team, 4:role, 5:managerStatus");
        int test = in.nextInt();
        in.nextLine();
    }
}
