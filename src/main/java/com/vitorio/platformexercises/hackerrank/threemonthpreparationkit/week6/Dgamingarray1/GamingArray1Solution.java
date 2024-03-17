package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Dgamingarray1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GamingArray1Solution {

    // ----------------- TODO TAGS:
    //   #value by value increment comparison

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            IntStream.range(0, t).forEach(i -> {
                List<Integer> arr = null;
                try {
                    int n = Integer.parseInt(bufferedReader.readLine());
                    arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(Result.gamingArray(arr));
            });
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'gamingArray' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static String gamingArray(List<Integer> arr) {
            // Based on solution submitted by user johnnyblaze19991
            int max = 0;
            int round = 0;

            for (int val : arr) {
                if (val > max) {
                    max = val;
                    round++;
                }
            }
            return round % 2 == 0 ? "ANDY" : "BOB";
        }
    }
}
