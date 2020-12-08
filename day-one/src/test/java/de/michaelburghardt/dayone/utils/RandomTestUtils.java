package de.michaelburghardt.dayone.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTestUtils {
    private RandomTestUtils(){}

    public static List<Integer> createPositiveRandomIntegerList(int size) {
        final List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final int rand = new Random().nextInt(Integer.MAX_VALUE -1);
            numbersList.add(rand);
        }
        return numbersList;
    }

    public static void writeRandomNumbersToFile(Path filePath, List<Integer> numbers) throws IOException {
        for (Integer number : numbers) {
            Files.writeString(filePath, number + "\n", StandardOpenOption.APPEND);
        }
    }
}
