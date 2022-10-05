package com.teamtool;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class ManagerTest {

    @Test
    void query() throws FileNotFoundException {
        Manager m = new Manager();
        m.query();
        ByteArrayInputStream in = new ByteArrayInputStream("brenden".getBytes());
        System.setIn(in);
    }

    @Test
    void addEmployee() {
    }

    @Test
    void changeEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}