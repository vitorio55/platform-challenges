package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Hsansaandxor;

import java.util.List;

public class SansaAndXorIgnoringEvenFrequenciesSolution extends SansaAndXorBaseMain {

    // https://www.geeksforgeeks.org/xor-subarray-xors/

    /*
     * Complete the 'sansaXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    @Override
    public int sansaXor(List<Integer> arr) {
        int xorSoFar = 0;
        for (int i = 0; i < arr.size(); i++) {
            int freq = (1 + i) * (arr.size() - i);
            // XOR result of elements with even frequencies is 0, so ignore
            if (freq % 2 == 0) {
                continue;
            }
            int val = arr.get(i);
            xorSoFar ^= val;
        }
        return xorSoFar;
    }
}
