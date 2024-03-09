package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Amaxmin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MaxMinSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int k = Integer.parseInt(bufferedReader.readLine());
            List<Integer> arr = IntStream.range(2, n + 2).mapToObj(i -> {
                    String s = null;
                    try {
                        s = bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return s;
                }).filter(Objects::nonNull)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
            return String.valueOf(Result.maxMin(k, arr));
        }
    }

    class Result {

        /*
         * Complete the 'maxMin' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY arr
         */

        public static int maxMin(int k, List<Integer> arr) {
            arr.sort(Comparator.naturalOrder());
            int minSub = Integer.MAX_VALUE;

            for (int i = 0; i <= arr.size() - k; i++) {
                int sub = arr.get(i + k - 1) - arr.get(i);
                if (sub < minSub) {
                    minSub = sub;
                }
            }
            return minSub;
        }
    }
}
