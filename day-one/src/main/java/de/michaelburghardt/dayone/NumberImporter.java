package de.michaelburghardt.dayone;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NumberImporter {

    public List<Integer> readNumbersFromFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
        return stream.map(Integer::parseInt)
                .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


}
