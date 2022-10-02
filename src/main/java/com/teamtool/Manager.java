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
        Scanner in = new Scanner(System.in);
        System.out.println("Enter employee name");
        String findEmployee = in.nextLine();
        System.out.println(findEmployee);
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addEmployee() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter a name");
        String name = input.nextLine();
        System.out.println("please enter a hire date");
        String hiredate = input.nextLine();
        System.out.println("please enter a team");
        String team = input.nextLine();
        System.out.println("please enter a role");
        String role = input.nextLine();
        System.out.println("is this employee a manager");
        String managerStatus = input.nextLine();
        System.out.printf("%s,%s,%s,%s,%s", name, hiredate, team, role, managerStatus);
        try {
            FileWriter fw =new FileWriter("Employee.csv", true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.newLine();
            writer.write(String.format("%s,%s,%s,%s,%s", name, hiredate, team, role, managerStatus));
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
