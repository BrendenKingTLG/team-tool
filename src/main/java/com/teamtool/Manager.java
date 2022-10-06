package com.teamtool;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static com.teamtool.Login.*;

public class Manager {
    private static String[] employeeArray = new String[6];
    private final String[] addEmployeeArray = new String[6];

    public Manager() {
    }

    public void inputForSearchByName() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter employee name");
        String findEmployee = in.nextLine().toLowerCase();
        searchByName(findEmployee);
    }

    public void searchByName(String findEmployee) throws IOException {
        String result = "Employee not found";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(findEmployee)) {
                    String[] theEmployeeArray = line.split(",");
                    result = String.format("" +
                                    "first-name:   %s%n" +
                                    "last-name:    %s%n" +
                                    "hire-date:    %s%n" +
                                    "team:         %s%n" +
                                    "role:         %s%n" +
                                    "is-manager:   %s%n",
                            theEmployeeArray[0], theEmployeeArray[1], theEmployeeArray[2], theEmployeeArray[3], theEmployeeArray[4], theEmployeeArray[5]);
                    employeeArray = theEmployeeArray;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new IOException("Could not find file");
        }
        System.out.println(result);
    }

    public void inputForSearchByTeam() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name of the team");
        String teamName = in.nextLine();
        searchByTeam(teamName);
    }

    public void searchByTeam(String teamName) throws IOException {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            System.out.printf("The members of %s are listed below:%n", teamName);
            while ((line = reader.readLine()) != null) {
                if (line.contains(teamName)) {
                    String[] teamArray = line.split(",");
                    String output = String.format("" +
                                    "first-name:   %s%n" +
                                    "last-name:    %s%n" +
                                    "hire-date:    %s%n" +
                                    "team:         %s%n" +
                                    "role:         %s%n" +
                                    "is-manager:   %s%n",
                            teamArray[0], teamArray[1], teamArray[2], teamArray[3], teamArray[4], teamArray[5]);
                    System.out.println(output);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new IOException("File not found");
        }
    }

    public void addEmployee(String[] addEmployeeArray) {
        try (FileWriter fw = new FileWriter("Employee.csv", true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            writer.newLine();
            writer.write(String.format("%s,%s,%s,%s,%s,%s", addEmployeeArray[0], addEmployeeArray[1], addEmployeeArray[2], addEmployeeArray[3], addEmployeeArray[4], addEmployeeArray[5]));
            System.out.println("\nSuccess! New employee created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void changeEmployee() throws IOException {
        inputForSearchByName();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (!line.contains(employeeArray[0]))
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
            System.out.printf("" +
                            "first-name:   %s%n" +
                            "last-name:    %s%n" +
                            "hire-date:    %s%n" +
                            "team:         %s%n" +
                            "role:         %s%n" +
                            "is-manager:   %s%n%n",
                    employeeArray[0], employeeArray[1], employeeArray[2], employeeArray[3], employeeArray[4], employeeArray[5]);
            PrintWriter writer = new PrintWriter(fileName);
            String sb = Arrays.toString(employeeArray);
            sb = sb.replace("[", "");
            sb = sb.replace("]", "");
            sb = sb.replaceAll("\\s+", "");
            str.append(sb);
            writer.write(String.valueOf(str));
            writer.close();
            System.out.println("Success! Employee changed\n");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void deleteEmployee() throws IOException {
        inputForSearchByName();
        try {
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
            System.out.println("\nSuccess! Employee was deleted\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUserInputForNewEmployee() {
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

