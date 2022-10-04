package com.teamtool;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class EmployeeTest {

  //should a Map be included for the test class? if yes, which one?

  //also all annotated @tests below are subject to group members' approval. This is simply a draft template to collaborate on.


  @Test
  public void query() throws IOException {

  }

  @Test
  void findViaId() {
    //final Employee ?????? = this.xxxxx.findbyId();
    //assertThat(employee.getId()).isEqualTo(#);
    //assertThat(employee.getFirstName()).isEqualTo("Nick");
    //assertThat(employee.getLastName()).isEqualTo("Bennett");

  }
  @Test
  void findAll() {
    //final EmployeeInfo employee-information = new EmployeeInfo();
    // I think a Comparator or Comparable goes here but not sure which one. :-|
    //assert????(employees).hasSize(#);
  }

  @Test
  void deleteEmployeeByFirstName() {
    FileReader.deleteByFirstName("deja");
    assertTrue();


    // final EmployeeInfo  employee-information = new EmployeeInfo();
    // employee-information.setFirstName("?");
    // Comparator or Comparable goes here?
    // assert????(employees).hasSize(#);
  }

  @Test
  void findViaLastName() {
    //final EmployeeInfo employee-information = new EmployeeInfo();
    // employee-information.setLastName("?");
    // Comparator or Comparable goes here?
    // asser
  }



  /* @Test
  void testEmploymentStatus() {

  }

  @Test
  void testEmployeeIdValue() {


  }
  @Test
  void testEmployeeName() {

  }
  */


}