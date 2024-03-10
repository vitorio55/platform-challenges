package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Fdivisiblesumpairs;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DivisibleSumPairsSolution {

    public static int main(String[] args) throws IOException {
        String[] split = args[0].split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        String[] vals = args[1].split(" ");
        List<Integer> ar = IntStream.range(0, n).mapToObj(i -> Integer.parseInt(vals[i])).collect(Collectors.toList());
        return Result.divisibleSumPairs(n, k, ar);
    }

    static class Result {

        /*
         * Complete the 'divisibleSumPairs' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER k
         *  3. INTEGER_ARRAY ar
         */

        public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
            // Based on solution submitted by user velninpapro
            Map<Integer, Integer> occurrences = new HashMap<>();
            int pairs = 0;

            for (Integer integer : ar) {
                int remainder = integer % k;
                int complementMult = (k - remainder) % k;
                pairs += occurrences.getOrDefault(complementMult, 0);
                occurrences.put(remainder, occurrences.getOrDefault(remainder, 0) + 1);
            }

            return pairs;
        }

    }
}
