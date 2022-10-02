package com.teamtool;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Manager extends Employee{

    static String notFound = "employee not found";
    static String fileName = "Employee.csv";

    public Manager(String name, LocalDate hireDate) {
        super(name, hireDate);
    }



    public static void query() throws FileNotFoundException {
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
                    String[] found = line.split(",");
                    String name = found[0];
                    String hireDate = found[1];
                    String team = found[2];
                    String role = found[3];
                    String managerStatus = found[4];
                    result = String.format("name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s", name, hireDate, team, role, managerStatus);
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

    public static void addEmployee() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter a name");
        String name = input.nextLine();
        System.out.println("please enter a hire date");
        String hireDate = input.nextLine();
        System.out.println("please enter a team");
        String team = input.nextLine();
        System.out.println("please enter a role");
        String role = input.nextLine();
        System.out.println("is this employee a manager");
        String managerStatus = input.nextLine();
        System.out.printf("name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s", name, hireDate, team, role, managerStatus);
        try {
            FileWriter fw =new FileWriter("Employee.csv", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.newLine();
            writer.write(String.format("%s,%s,%s,%s,%s", name, hireDate, team, role, managerStatus));
            writer.close();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void changeEmployee() {

    }

    void deleteEmployee() {

    }
}
