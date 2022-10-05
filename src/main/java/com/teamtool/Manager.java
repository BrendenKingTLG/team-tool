package com.teamtool;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;import static com.teamtool.Login.*;

    public class Manager {
    private final String[] addEmployeeArray = new String[6];

    public Manager() {
    }

    public void inputForSearchByName() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter employee name");
        String findEmployee = in.nextLine().toLowerCase();
        searchByName(findEmployee);
    }

    public void searchByName(String findEmployee) throws FileNotFoundException {
        String result = "Employee not found";
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(findEmployee)) {
                    String[] employeeArray = line.split(",");
                    result = String.format("" +
                            "first-name:   %s%n" +
                            "last-name:    %s%n" +
                            "hire-date:    %s%n" +
                            "team:         %s%n" +
                            "role:         %s%n" +
                            "is-manager:   %s%n",
                        employeeArray[0], employeeArray[1], employeeArray[2], employeeArray[3], employeeArray[4], employeeArray[5]);
                    Login.employeeArray = employeeArray;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new FileNotFoundException("Could not find file");
        }
        System.out.println(result);
    }

    public void inputForSearchByTeam() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name of the team");
        String teamName = in.nextLine();
        searchByTeam(teamName);
    }

    public void searchByTeam(String teamName) throws FileNotFoundException {
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            System.out.printf("The members of %s are listed below:%n", teamName);
            while ((line = reader.readLine()) != null){
                if(line.contains(teamName)){
                    String[] teamArray = line.split(",");
                    String output = String.format("" +
                            "first-name:   %s%n" +
                            "last-name:    %s%n" +
                            "hire-date:    %s%n" +
                            "team:         %s%n" +
                            "role:         %s%n" +
                            "is-manager:   %s%n",
                        teamArray[0], teamArray[1], teamArray[2], teamArray[3], teamArray[4], teamArray[5]);
                    System.out.println( output );
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new FileNotFoundException("File not found");
        }
        startApp();
    }

    public void addEmployee(String[] addEmployeeArray) throws FileNotFoundException {
        try (FileWriter fw = new FileWriter("Employee.csv", true);
             BufferedWriter writer = new BufferedWriter(fw)) {
                writer.newLine();
                writer.write(String.format("%s,%s,%s,%s,%s,%s", addEmployeeArray[0], addEmployeeArray[1], addEmployeeArray[2], addEmployeeArray[3], addEmployeeArray[4], addEmployeeArray[5]));
                System.out.println("\nSuccess! New employee created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        startApp();
    }

    public void changeEmployee() throws FileNotFoundException {
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
            Scanner in = new Scanner(System.in);
            System.out.printf("What would you like to change?%n"
                            +"0:first-name%n"
                            +"1:last-name%n"
                            +"2:hireDate%n"
                            +"3:team%n"
                            +"4:role%n"
                            +"5:managerStatus%n");
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startApp();
    }

    public void deleteEmployee() throws FileNotFoundException {
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
            System.out.println("\nSuccess! Employee was deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
        startApp();
    }

    public void getUserInputForNewEmployee() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter first name");
        this.addEmployeeArray[0] = input.nextLine().toLowerCase();
        System.out.println("Please enter last name");
        this.addEmployeeArray[1] = input.nextLine().toLowerCase();
        System.out.println("Please enter a hire date format: YYYY-MM-DD");
        this.addEmployeeArray[2] = input.nextLine();
        while (!this.addEmployeeArray[2].matches("\\d{4}-\\d{2}-\\d{2}")){
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
