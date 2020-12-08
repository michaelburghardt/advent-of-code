package de.michaelburghardt.dayone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DayOneApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DayOneApplication.class);
    private static NumberImporter numberImporter;

    @Autowired
    public DayOneApplication(NumberImporter numberImporter) {
        DayOneApplication.numberImporter = numberImporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(DayOneApplication.class, args);

        final String filePath = "/Users/michaelburghardt/IdeaProjects/advent-of-code/day-one/data/numbers.txt";
        final List<Integer> numbers = numberImporter.readNumbersFromFile(filePath);
        final int[] numberPair = NumberPairFinder.findNumberPair(numbers, 2020);
        LOG.info("Requested numbers are {} and {}", numberPair[0], numberPair[1]);
        LOG.info("Requested result is {}", numberPair[0] * numberPair[1]);
    }
}
