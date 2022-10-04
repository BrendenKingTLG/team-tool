package com.teamtool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

  static String fileName = "Employee.csv";

  public static void employeeAuthentication(){

    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your first-name");
    String loginName = input.nextLine();
    try{
      FileReader fileReader = new FileReader(fileName);
      BufferedReader reader = new BufferedReader(fileReader);
      String line;
      while((line = reader.readLine()) !=null){
        if(line.startsWith(loginName)){
          System.out.println("it worked!");
        }else {
          System.out.println("didn't work");
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }
}
