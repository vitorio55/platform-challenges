package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Hsansaandxor;

import java.util.List;

public class SansaAndXorIgnoringOddIndexesSolution extends SansaAndXorBaseMain {

    /*
     * Complete the 'sansaXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    @Override
    public int sansaXor(List<Integer> arr) {
        if (arr.size() % 2 == 0) {
            return 0;
        }

        int xorSoFar = 0;
        for (int i = 0; i < arr.size(); i++) {
            // According to this reference: https://www.geeksforgeeks.org/xor-subarray-xors/ ...
            // Odd indexes coincide with even frequencies, which we can ignore since XOR 'even' times among the
            // same element value result in zero
            if (i % 2 == 1) {
                continue;
            }
            xorSoFar ^= arr.get(i);
        }
        return xorSoFar;
    }
}
