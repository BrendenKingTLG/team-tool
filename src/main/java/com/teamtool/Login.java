package com.teamtool;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    static final String fileName = "Employee.csv";
    private static String[] userArray = new String[6];
    static String[] employeeArray = new String[6];
    private static boolean auth = false;

    /**
     *
     */
    public static void authentication() {
        System.out.printf("Welcome to Team Tool%n"
                        +"Please enter your name%n");
            Scanner in = new Scanner(System.in);
            String user = in.nextLine().toLowerCase();
            try (BufferedReader reader = new BufferedReader( new InputStreamReader(Login.class.getClassLoader().getResourceAsStream(fileName)))){
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(user)) {
                        userArray = line.split(",");
                        if (Objects.equals(userArray[0], user)){
                            auth = true;
                            System.out.println("Hello " + userArray[0] + "!");
                        }
                    }
                }
                startApp();


            } catch (URISyntaxException | IOException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void startApp() throws IOException, URISyntaxException {
        mainMenu:
        while (true) {
            if (auth) {
                if (userArray[5].equals("yes")) {
                    Manager m = new Manager();
                    System.out.printf("What would you like to do?%n"
                                    + "1: Search by name%n"
                                    + "2: Search by team name%n"
                                    + "3: Add a new employee%n"
                                    + "4: Delete an employee%n"
                                    + "5: Update employee information%n"
                                    + "0: Quit%n");
                    Scanner in = new Scanner(System.in);
                    int input = in.nextInt();
                    in.nextLine();
                    switch (input) {
                        case 0:
                            break mainMenu;
                        case 1:
                            m.inputForSearchByName();
                            break;
                        case 2:
                            m.inputForSearchByTeam();
                            break;
                        case 3:
                            m.getUserInputForNewEmployee();
                            break;
                        case 4:
                            m.deleteEmployee();
                            break;
                        case 5:
                            m.changeEmployee();
                            break;
                        default:
                            System.out.println("You did not choose a valid option.");
                            break;
                    }
                }
                if (userArray[5].equals("no")) {
                    Subordinate s = new Subordinate();
                    System.out.printf("What would you like to do?%n"
                                    + "1: Search by name%n"
                                    + "2: Search by team name%n"
                                    + "0: Quit%n");
                    Scanner in = new Scanner(System.in);
                    int input = in.nextInt();
                    in.nextLine();
                    switch (input){
                        case 0:
                            break mainMenu;
                        case 1:
                            s.searchByName();
                            break;
                        case 2:
                            s.subordinateInputForSearchByTeam();
                            break;
                        default:
                            System.out.println("You did not choose a valid option.");
                            break;
                    }
                }
            } else {
                System.out.println("Not authenticated");
            }
        }
    }
}
