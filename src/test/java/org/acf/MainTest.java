package org.acf;


import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.acf.Main.computeIndexSumsForTarget;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for static Main/computeIndexSumsForTarget")
public class MainTest {

    @DisplayName("Use given sample as base pass test")
    @Test
    public void SuppliedSamplePassTest() {
        int[] sampleData = new int[] {7, 2, 15, 11};
        int[] expectedIndexes = new int[] {1, 2};
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 9);
        assertArrayEquals(expectedIndexes, actualIndexes);
    }
    @DisplayName("Use given sample as base fail test")
    @Test
    public void SuppliedSampleFailTest() {
        int[] sampleData = new int[] {7, 2, 15, 11};
        int[] expectedIndexes = new int[] {1, 2};
        // A target value of 10 will not work given in input values
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 10);
        assertFalse(Arrays.equals(expectedIndexes, actualIndexes));
    }

}