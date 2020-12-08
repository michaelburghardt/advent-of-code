package de.michaelburghardt.dayone;

import de.michaelburghardt.dayone.utils.RandomTestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DayOneApplication.class)
class NumberImporterTest {

    @Autowired
    private NumberImporter numberImporter;

    private Path tempNumberFile;
    @BeforeEach
    void setUp() throws IOException {
        tempNumberFile = Files.createTempFile(null, null);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(tempNumberFile);
    }



    @Test
    public void testThatCorrectNumberOfIntegersAreImported() throws IOException {
        int numbersListSize = 20;
        final List<Integer> numbersList = RandomTestUtils.createPositiveRandomIntegerList(numbersListSize);
        RandomTestUtils.writeRandomNumbersToFile(tempNumberFile, numbersList);

        final List<Integer> numbersFromFile = numberImporter.readNumbersFromFile(tempNumberFile.toString());

    }

    @Test
    public void testReadNumbersFromFileThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            final List<Integer> numbersFromFile = numberImporter.readNumbersFromFile(null);

        });
    }

    @Test
    public void testThatAllNumbersAreImported() throws IOException {
        int numbersListSize = 20;
        final List<Integer> numbersList = RandomTestUtils.createPositiveRandomIntegerList(numbersListSize);
        RandomTestUtils.writeRandomNumbersToFile(tempNumberFile, numbersList);

        final List<Integer> numbersFromFile = numberImporter.readNumbersFromFile(tempNumberFile.toString());

        assertTrue(numbersFromFile.containsAll(numbersList));
    }

}