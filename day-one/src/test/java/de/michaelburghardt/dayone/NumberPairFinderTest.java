package de.michaelburghardt.dayone;

import de.michaelburghardt.dayone.utils.RandomTestUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberPairFinderTest {

    @Test
    public void testThatNumberPairContainsTwoNumbers() throws IOException {
        final int number1 = 1;
        final int number2 = 2;
        final int numbersListSize = 20;
        final List<Integer> numberList = RandomTestUtils.createPositiveRandomIntegerList(numbersListSize);
        numberList.add(0, number1);
        numberList.add(number2);

        final int[] numberPair = NumberPairFinder.findNumberPair(numberList, number1 + number2);

        assertEquals(2, numberPair.length);
    }

    @Test
    public void testThatNumberPairContainsNoNumbersWhenTargetSumIsInvalid() throws IOException {
        final int number1 = 1;
        final int number2 = 2;
        final int numbersListSize = 20;
        final List<Integer> numberList = RandomTestUtils.createPositiveRandomIntegerList(numbersListSize);
        numberList.add(0, number1);
        numberList.add(number2);

        final int[] numberPair = NumberPairFinder.findNumberPair(numberList, -1);

        assertEquals(0, numberPair.length);
    }

    @Test
    public void testThatRightNumberPairIsFound() throws IOException {
        final int number1 = 1;
        final int number2 = 2;
        final int numbersListSize = 20;
        final List<Integer> numberList = RandomTestUtils.createPositiveRandomIntegerList(numbersListSize);
        numberList.add(0, number1);
        numberList.add(number2);

        final int[] numberPair = NumberPairFinder.findNumberPair(numberList, number1 + number2);

        assertTrue(IntStream.of(numberPair).anyMatch( i -> i == number1));
        assertTrue(IntStream.of(numberPair).anyMatch( i -> i == number2));
    }
}