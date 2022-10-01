package com.teamtool;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Manager extends Employee{



    public Manager(String name, LocalDate hireDate) {
        super(name, hireDate);
    }


    @Override
    void query() {

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
        try (FileWriter writer = new FileWriter("output.csv")){
            writer.write(String.format("%s,%s,%s,%s,%s", name, hiredate, team, role, managerStatus));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void changeEmployee() {

    }

    void deleteEmployee() {

    }
}
