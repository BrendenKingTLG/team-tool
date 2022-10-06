package com.teamtool;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Loader {

    /**
     * @param fileName
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public List<String[]> loadEmployees (String fileName) throws URISyntaxException, IOException {
        URI uri = Loader.class
                .getClassLoader()
                .getResource("Employee.csv")
                .toURI();
        Path path = Path.of(uri);


        return Files.lines(path)
                .skip(1)
                .map(String::trim)
                .filter((line) -> !line.isEmpty())
                .map((line) -> line.split("\\s*,\\s*"))
                .collect(Collectors.toList());
    }
}


