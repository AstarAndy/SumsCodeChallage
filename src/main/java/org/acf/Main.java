package org.acf;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

    }

    /**
     * Takes an array of ints and will return the index position in the array
     * of two numbers that sum to the given target.  Otherwise will return 0,0
     * in the array
     * @param numbers An array of integers between -1000 and 1000 with a size of 2000 entries
     * @param target This should be the sum of two numbers in the array.  This is what we are looking for
     * @return int[1] where 0 is the first number and 1 is the second or 0,0 if no solution is found
     */
    public static int[] computeIndexSumsForTarget(int[] numbers, int target) {
        int[] result = new int[] {0,0};

        // Fail if array is not properly initialized with values
        if (numbers == null || numbers.length == 0 || target == 0) {
            System.out.println("The array is empty or null or the target value is 0.  Leaving");
            return result;
        }

        // Requirement.  Array must be sorted
        Arrays.sort(numbers);

        // Squeeze the start and end test indexes till we find the right combo

        int startingIdx = 0;
        int endingIdx = (numbers.length - 1);
        int testValue = 0;
        String fmtVal = "Found sum at positions %d and %d.  Value %d + %d = %d.  Leaving";

        while (startingIdx < endingIdx) {
            testValue = numbers[startingIdx] + numbers[endingIdx];
            if ( testValue == target) {
                result[0] = (startingIdx + 1);
                result[1] = (endingIdx + 1);
                String logEntry = String
                        .format(fmtVal,
                                result[0],
                                result[1],
                                numbers[startingIdx],
                                numbers[endingIdx],
                                testValue);
                System.out.println(logEntry);
                return result;
            }
            if (testValue < target) {
                startingIdx++;
            } else {
                endingIdx--;
            }

        }

        //If we're here we didn't find the correct sum values for the given target
        System.out.println("No combinations found in input that sum to: " + target);
        return result;

    }
}