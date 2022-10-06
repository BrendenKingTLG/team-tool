package com.teamtool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Subordinate extends Manager {

    public Subordinate() {
        super();
    }

    public void searchByName() throws IOException, URISyntaxException {
        super.inputForSearchByName();
    }

    public void subordinateInputForSearchByTeam() throws IOException, URISyntaxException {
        super.inputForSearchByTeam();
    }

}
