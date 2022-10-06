package com.teamtool;

import java.io.FileNotFoundException;

public class Subordinate extends Manager {

    public Subordinate() {
        super();
    }

    public void searchByName() throws FileNotFoundException {
        super.inputForSearchByName();
    }

    public void subordinateInputForSearchByTeam() throws FileNotFoundException {
        super.inputForSearchByTeam();
    }

}
