package com.teamtool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    static final String fileName = "Employee.csv";
    private static String[] userArray = new String[6];

    public static void authentication() {
        System.out.printf("Welcome to Team Tool%n"
                        +"Please enter your name%n");
            Scanner in = new Scanner(System.in);
            String user = in.nextLine().toLowerCase();
            try (BufferedReader reader = new BufferedReader( new FileReader(fileName))){
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(user)) {
                        userArray = line.split(",");
                        if (Objects.equals(userArray[0], user)){
                            System.out.println("Hello " + userArray[0] + "!");
                        }
                    }
                }
                mainMenu();
            } catch (RuntimeException | IOException e) {
                e.printStackTrace();
            }
}

    public static void mainMenu() throws IOException {
        mainMenu:
        while (true) {
                if (userArray[5].equals("yes")) {
                    Manager m = new Manager();
                    System.out.printf("What would you like to do?%n"
                                    + "1: Search by team name%n"
                                    + "2: Search by first name%n"
                                    + "3: Delete an employee%n"
                                    + "4: Update employee information%n"
                                    + "5: Add a new employee%n"
                                    + "0: Quit%n");
                    Scanner in = new Scanner(System.in);
                    int input = in.nextInt();
                    in.nextLine();
                    switch (input) {
                        case 0:
                            break mainMenu;
                        case 1:
                            m.inputForSearchByTeam();
                            break;
                        case 2:
                            m.inputForSearchByName();
                            break;
                        case 3:
                            m.deleteEmployee();
                            break;
                        case 4:
                            m.changeEmployee();
                            break;
                        case 5:
                            m.getUserInputForNewEmployee();
                            break;
                        default:
                            System.out.println("You did not choose a valid option.");
                            break;
                    }
                }
                if (userArray[5].equals("no")) {
                    Subordinate s = new Subordinate();
                    System.out.printf("What would you like to do?%n"
                                    + "1: Search by first name%n"
                                    + "2: Search by team name%n"
                                    + "0: Quit%n");
                    Scanner in = new Scanner(System.in);
                    int input = in.nextInt();
                    in.nextLine();
                    switch (input){
                        case 0:
                            break mainMenu;
                        case 1:
                            s.subordinateSearchByName();
                            break;
                        case 2:
                            s.subordinateInputForSearchByTeam();
                        default:
                            System.out.println("You did not choose a valid option.");
                            break;
                    }
                }
            }
        }
    }
