package com.teamtool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    static final String fileName = "Employee.csv";
    private static String[] userArray = new String[6];
    static String[] employeeArray = new String[6];
    private static boolean auth = false;

    public static void authentication() {
            System.out.println("Please enter your name");
            Scanner in = new Scanner(System.in);
            String user = in.nextLine().toLowerCase();
            try (BufferedReader reader = new BufferedReader( new FileReader(fileName))){
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(user)) {
                        userArray = line.split(",");
                        if (Objects.equals(userArray[0], user)){
                            auth = true;
                            System.out.println("hi " + userArray[0] + "!");
                        }
                    }
                }
                startApp();
            } catch (RuntimeException e) {
                throw new RuntimeException();
            } catch (IOException e) {
                e.printStackTrace();
            }
}

    public static void startApp() throws FileNotFoundException {
        if (auth) {
            if (userArray[5].equals("yes")) {
                Manager m = new Manager();
                System.out.println("what would you like to do? 0:search-name, 1:search-team, 2:add-employee, 3:delete-employee, 4:change-employee");
                Scanner in = new Scanner(System.in);
                int input = in.nextInt();
                in.nextLine();
                switch (input) {
                    case 0:
                        m.searchByName();
                        break;
                    case 1:
                        m.searchByTeam();
                        break;
                    case 2:
                        m.addEmployee();
                        break;
                    case 3:
                        m.deleteEmployee();
                        break;
                    case 4:
                        m.changeEmployee();
                        break;
                    default:
                        System.out.println("you did not choose a valid option");
                        break;
                }
            }
            if (userArray[5].equals("no")) {
                Subordinate s = new Subordinate();
                s.searchByName();
            }
        } else {
            System.out.println("not authenticated");
        }
    }
}
