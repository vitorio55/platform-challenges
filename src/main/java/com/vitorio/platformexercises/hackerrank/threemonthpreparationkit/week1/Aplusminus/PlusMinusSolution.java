package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Aplusminus;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class PlusMinusSolution {

    public static String main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);
        List<Integer> arr = Arrays.stream(args[1].split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        return Result.plusMinus(arr);
    }

    static class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static String plusMinus(List<Integer> arr) {
            var doubleVals = arr.stream().map(Double::valueOf).collect(toList());
            var size = (double) arr.size();
            return composePositivesRatio(doubleVals, size) + "\n" +
                composeNegativesRatio(doubleVals, size) + "\n" +
                composeZeroRatio(doubleVals, size) + "\n";
        }

        private static String composePositivesRatio(List<Double> arr, double size) {
            return String.format("%.6f", arr.stream().filter(n -> n > 0).count() / size).replace(",", ".");

        }

        private static String composeNegativesRatio(List<Double> arr, double size) {
            return String.format("%.6f", arr.stream().filter(n -> n < 0).count() / size).replace(",", ".");
        }

        private static String composeZeroRatio(List<Double> arr, double size) {
            return String.format("%.6f", arr.stream().filter(n -> n == 0).count() / size).replace(",", ".");
        }

    }
}
