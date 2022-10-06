package com.teamtool;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Subordinate extends Manager {

    public Subordinate() {
        super();
    }

    public void searchByName() throws FileNotFoundException {
        super.inputForSearchByName();
    }

    public void subordinateInputForSearchByTeam() throws IOException {
        super.inputForSearchByTeam();
    }

}
