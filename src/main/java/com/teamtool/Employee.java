package com.teamtool;

import java.io.FileNotFoundException;

public abstract class Employee {

    public Employee(){
    }

    public abstract void searchByTeam() throws FileNotFoundException;

    public abstract void searchByName() throws FileNotFoundException;
}
