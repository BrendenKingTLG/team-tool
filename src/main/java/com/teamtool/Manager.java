package com.teamtool;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

import static com.teamtool.Login.*;

public class Manager {
    /**
     *
     */
    private final String[] addEmployeeArray = new String[6];

    /**
     *
     */
    public Manager() {
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void inputForSearchByName() throws IOException, URISyntaxException {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter employee name");
        String findEmployee = in.nextLine().toLowerCase();
        searchByName(findEmployee);
    }

    /**
     * @param findEmployee
     * @throws IOException
     * @throws URISyntaxException
     */
    public void searchByName(String findEmployee) throws IOException, URISyntaxException {
        String result = "Employee not found";
        Loader loader = new Loader();
        for (String[] data : loader.loadEmployees("Employee.csv")) {
            if (data[0].startsWith(findEmployee)) {
                result = String.format("" +
                                "first-name:   %s%n" +
                                "last-name:    %s%n" +
                                "hire-date:    %s%n" +
                                "team:         %s%n" +
                                "role:         %s%n" +
                                "is-manager:   %s%n",
                        data[0], data[1], data[2], data[3], data[4], data[5]);
                Login.employeeArray = data;
                break;
            }
        }
        System.out.println(result);
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void inputForSearchByTeam() throws IOException, URISyntaxException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name of the team");
        String teamName = in.nextLine();
        searchByTeam(teamName);
    }

    /**
     * @param teamName
     * @throws IOException
     * @throws URISyntaxException
     */
    public void searchByTeam(String teamName) throws IOException, URISyntaxException {
            System.out.printf("The members of %s are listed below:%n", teamName);
        Loader loader = new Loader();

        for (String[] data : loader.loadEmployees("Employee.csv")) {
                if (data[3].contains(teamName)) {
                    String output = String.format("" +
                                    "first-name:   %s%n" +
                                    "last-name:    %s%n" +
                                    "hire-date:    %s%n" +
                                    "team:         %s%n" +
                                    "role:         %s%n" +
                                    "is-manager:   %s%n",
                            data[0], data[1], data[2], data[3], data[4], data[5]);
                    System.out.println(output);
                }
            }
    }

    /**
     * @param addEmployeeArray
     * @throws IOException
     * @throws URISyntaxException
     */
    public void addEmployee(String[] addEmployeeArray) throws IOException, URISyntaxException {
        try (FileWriter fw = new FileWriter("Employee.csv", true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            writer.newLine();
            writer.write(String.format("%s,%s,%s,%s,%s,%s", addEmployeeArray[0], addEmployeeArray[1], addEmployeeArray[2], addEmployeeArray[3], addEmployeeArray[4], addEmployeeArray[5]));
            System.out.println("\nSuccess! New employee created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void changeEmployee() throws IOException, URISyntaxException {
        try {
            inputForSearchByName();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(employeeArray[0]))
                    str.append(line);
                str.append("\n");
            }
            Scanner in = new Scanner(System.in);
            System.out.printf("What would you like to change?%n"
                    + "0:first-name%n"
                    + "1:last-name%n"
                    + "2:hireDate%n"
                    + "3:team%n"
                    + "4:role%n"
                    + "5:managerStatus%n");
            int test = in.nextInt();
            in.nextLine();
            System.out.println("Enter desired change");
            String change = in.nextLine().toLowerCase();
            employeeArray[test] = change;
            System.out.println(Arrays.toString(employeeArray));
            PrintWriter writer = new PrintWriter(fileName);
            String sb = Arrays.toString(employeeArray);
            sb = sb.replace("[", "");
            sb = sb.replace("]", "");
            sb = sb.replaceAll("\\s+", "");
            str.append(sb);
            writer.write(String.valueOf(str));
            writer.close();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void deleteEmployee() throws IOException, URISyntaxException {
        try {
            inputForSearchByName();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(employeeArray[0]))
                    str.append(line);
                str.append("\n");
            }
            PrintWriter writer = new PrintWriter(fileName);
            writer.print(str);
            writer.close();
            System.out.println("\nSuccess! Employee was deleted");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void getUserInputForNewEmployee() throws IOException, URISyntaxException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter first name");
        this.addEmployeeArray[0] = input.nextLine().toLowerCase();
        System.out.println("Please enter last name");
        this.addEmployeeArray[1] = input.nextLine().toLowerCase();
        System.out.println("Please enter a hire date format: YYYY-MM-DD");
        this.addEmployeeArray[2] = input.nextLine();
        while (!this.addEmployeeArray[2].matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Please enter date in the correct format.  Ex: YYYY-MM-DD");
            this.addEmployeeArray[2] = input.nextLine();
        }
        System.out.println("Please enter a team");
        this.addEmployeeArray[3] = input.nextLine().toLowerCase();
        System.out.println("Please enter a role");
        this.addEmployeeArray[4] = input.nextLine().toLowerCase();
        System.out.println("Is this employee a manager?");
        this.addEmployeeArray[5] = input.nextLine().toLowerCase();
        addEmployee(addEmployeeArray);
    }

}
