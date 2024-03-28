package org.acf;


import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.acf.Main.computeIndexSumsForTarget;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for static Main/computeIndexSumsForTarget")
public class MainTest {

    @DisplayName("Use given sample as base pass test")
    @Test
    public void suppliedSamplePassTest() {
        int[] sampleData = new int[] {7, 2, 15, 11};
        int[] expectedIndexes = new int[] {1, 2};
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 9);
        assertArrayEquals(expectedIndexes, actualIndexes);
    }
    @DisplayName("Use given sample as base fail test")
    @Test
    public void suppliedSampleFailTest() {
        int[] sampleData = new int[] {7, 2, 15, 11};
        int[] expectedIndexes = new int[] {1, 2};
        // A target value of 10 will not work given in input values
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 10);
        assertFalse(Arrays.equals(expectedIndexes, actualIndexes));
    }

    @DisplayName("Target MIN edge value -1000 Test")
    @Test
    public void getTargetNegative1000Test() {
        int[] sampleData = getSampleData(10000, false);
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, -1000);
        int sumOfIndexes = Arrays.stream(actualIndexes).sum();
        assertTrue(sumOfIndexes > 0);
    }

    @DisplayName("Target MaX edge 1000 Test")
    @Test
    public void getTargetPositive1000Test() {
        int[] sampleData = getSampleData(10000, false);
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 1000);
        int sumOfIndexes = Arrays.stream(actualIndexes).sum();
        assertTrue(sumOfIndexes > 0);
    }

    @DisplayName("Target value 527")
    @Test
    public void target527Test() {
        int[] sampleData = getSampleData(10000, false);
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 527);
        int sumOfIndexes = Arrays.stream(actualIndexes).sum();
        assertTrue(sumOfIndexes > 0);

    }

    @DisplayName("Target value 249")
    @Test
    public void target249Test() {
        int[] sampleData = getSampleData(10000, false);
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 249);
        int sumOfIndexes = Arrays.stream(actualIndexes).sum();
        assertTrue(sumOfIndexes > 0);

    }

    @DisplayName("Target value 0 should fail")
    @Test
    public void target0Test() {
        int[] sampleData = getSampleData(10000, false);
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 0);
        int sumOfIndexes = Arrays.stream(actualIndexes).sum();
        assertFalse(sumOfIndexes > 0);

    }


    /**
     * This is used to generate an array of sample data with the supplied size
     * @param sampleSize any number
     * @return int[] Array of sampleSize with each entry randomly generated between -1000 and 1000
     */
    private int[] getSampleData(int sampleSize, boolean logData) {
        int[] result = new int[sampleSize];
        for (int idx = 0; idx < sampleSize; idx++) {
            result[idx] = ThreadLocalRandom.current().nextInt(-1000, 1001);
        }

        if (logData) {
            StringJoiner sj = new StringJoiner(",", "[", "]");
            Arrays.stream(result).mapToObj(Integer::toString).forEach(sj::add);
            System.out.println(sj.toString());
        }

        return result;
    }

}