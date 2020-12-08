package de.michaelburghardt.dayone;

import java.util.List;

public class NumberPairFinder {

    public static int[] findNumberPair(List<Integer> numbers, int targetSum) {
        int firstNumber = -1, secondNumber = -1;
        for (int first : numbers) {
            for (int second : numbers) {
                if (first == second) continue;
                final int sum = first + second;
                if (sum == targetSum) {
                    firstNumber = first;
                    secondNumber = second;
                }
            }
        }
        if (-1 == firstNumber || -1 == secondNumber)
            return new int[]{};

        return new int[] {firstNumber, secondNumber};
    }
}
