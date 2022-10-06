package com.teamtool;

import java.io.IOException;
import java.net.URISyntaxException;

public class Subordinate extends Manager {

    /**
     *
     */
    public Subordinate() {
        super();
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void searchByName() throws IOException, URISyntaxException {
        super.inputForSearchByName();
    }

    /**
     * @throws IOException
     * @throws URISyntaxException
     */
    public void subordinateInputForSearchByTeam() throws IOException, URISyntaxException {
        super.inputForSearchByTeam();
    }

}
