package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Imocktest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class FibonacciModifiedSolution {

    // ----------------- TODO TAGS:
    //   #fibonacci
    //   #bigdecimal

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String[] vals = bufferedReader.readLine().split(" ");
            List<Integer> arr = Arrays.stream(vals)
                .map(Integer::parseInt)
                .collect(toList());

            int t1 = arr.get(0);
            int t2 = arr.get(1);
            int n = arr.get(2);
            return String.valueOf(Result.fibonacciModified(t1, t2, n));
        }
    }

    static class Result {

        /*
         * Complete the 'fibonacciModified' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER t1
         *  2. INTEGER t2
         *  3. INTEGER n
         */

        public static BigDecimal fibonacciModified(int t1, int t2, int n) {
            Map<Integer, BigDecimal> knownAnswers = new HashMap<>();
            knownAnswers.put(1, new BigDecimal(t1));
            knownAnswers.put(2, new BigDecimal(t2));
            return recurse(n, knownAnswers);
        }

        private static BigDecimal recurse(int n, Map<Integer, BigDecimal> knowAnswers) {
            if (knowAnswers.containsKey(n)) {
                return knowAnswers.get(n);
            }

            BigDecimal iMinusTwo = knowAnswers.getOrDefault(n - 2, recurse(n - 2, knowAnswers));
            if (!knowAnswers.containsKey(n - 2)) {
                knowAnswers.put(n - 2, iMinusTwo);
            }

            BigDecimal iMinusOne = knowAnswers.getOrDefault(n - 1, recurse(n - 1, knowAnswers));
            if (!knowAnswers.containsKey(n - 1)) {
                knowAnswers.put(n - 1, iMinusOne);
            }
            return  iMinusTwo.add(iMinusOne.multiply(iMinusOne));
        }
    }
}
