package com.teamtool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    static final String fileName = "Employee.csv";
    public static String[] userArray = new String[6];
    static String[] employeeArray = new String[6];
    private static boolean auth = false;

    public static void authentication() {
            System.out.println("Please enter your name");
            Scanner in = new Scanner(System.in);
            String user = in.nextLine();
            try (BufferedReader reader = new BufferedReader( new FileReader(fileName))){
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(user)) {
                        userArray = line.split(",");
                        if (Objects.equals(userArray[0], user)){
                            auth = true;
                        }
                    }
                }
                startApp();
            } catch (RuntimeException e) {
                throw new RuntimeException();
            } catch (IOException e) {
                e.printStackTrace();
            }
}//

    public static void startApp() {
        if (auth) {
            if (userArray[5].equals("yes")) {
                Manager m = new Manager();
                System.out.println("what would you like to do? 0:query-firstname, 1:add-employee, 2:change-employee, 3:delete-employee");
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
        } else {
            System.out.println("not authenticated");
        }
    }
}
