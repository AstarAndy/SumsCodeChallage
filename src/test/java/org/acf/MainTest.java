package org.acf;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.acf.Main.computeIndexSumsForTarget;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Tests for static Main/computeIndexSumsForTarget")
public class MainTest {

    @DisplayName("Use given sample as base test")
    @Test
    public void SuppliedSampleBaseTest() {
        int[] sampleData = new int[] {7, 2, 15, 11};
        int[] expectedIndexes = new int[] {1, 2};
        int[] actualIndexes = computeIndexSumsForTarget(sampleData, 9);
        assertArrayEquals(expectedIndexes, actualIndexes);
    }

}