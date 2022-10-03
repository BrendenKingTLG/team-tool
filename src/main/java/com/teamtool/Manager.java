package com.teamtool;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Manager extends Employee{

    static String notFound = "employee not found";
    static String fileName = "Employee.csv";

    public Manager(String name, LocalDate hireDate) {
        super();
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
                    String firstName = found[0];
                    String lastName = found[1];
                    String hireDate = found[2];
                    String team = found[3];
                    String role = found[4];
                    String managerStatus = found[5];
                    result = String.format("first-name:%s, last-name:%s, hire-date:%s, team:%s, role:%s, is-manager: %s", firstName, lastName, hireDate, team, role, managerStatus);
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
    public static void addEmployee() throws IOException {

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

    void changeEmployee() {

    }

    void deleteEmployee() {

    }
}
