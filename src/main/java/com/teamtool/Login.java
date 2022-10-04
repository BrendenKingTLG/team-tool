package com.teamtool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    static final String fileName = "Employee.csv";
    public static String[] userArray = new String[6];
    static String[] employeeArray = new String[6];

    public static void authentication() {
        System.out.println("Please enter your name");
        Scanner in = new Scanner(System.in);
        String user = in.nextLine();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(user)) {
                    userArray = line.split(",");
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startApp() {
        if (userArray[5].equals("yes")) {
            Manager m = new Manager();
            System.out.println("what would you like to do? 0:query, 1:add-employee, 2:change-employee, 3:delete-employee");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            in.nextLine();
            switch (input) {
                case 0:
                    m.query();
                    break;
                case 1:
                    m.addEmployee();
                    break;
                case 2:
                    m.changeEmployee();
                    break;
                case 3:
                    m.deleteEmployee();
                    break;
                default:
                    System.out.println("you did not choose a valid option");
                    break;
            }

        }
        if (userArray[5].equals("no")) {
            Subordinate s = new Subordinate();
            s.query();
        }
    }
}
