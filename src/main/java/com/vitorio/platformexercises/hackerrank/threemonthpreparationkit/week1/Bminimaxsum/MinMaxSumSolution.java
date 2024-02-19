package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Bminimaxsum;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MinMaxSumSolution {

    public static String main(String[] args) throws IOException {
        List<Integer> arr = Stream.of(args[0].replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        return Result.miniMaxSum(arr);
    }

    class Result {

        /*
         * Complete the 'miniMaxSum' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static String miniMaxSum(List<Integer> arr) {
            // Write your code here
            return composeMinSum(arr) + " " + composeMaxSum(arr);
        }

        private static String composeMinSum(List<Integer> arr) {
            List<Long> withoutMax = arr.stream()
                .map(element -> Long.valueOf(element.toString()))
                .sorted()
                .collect(Collectors.toList());

            withoutMax.remove(arr.size() - 1);

            Long sum = withoutMax.stream().reduce((long) 0, Long::sum);
            return Long.toString(sum);
        }

        private static String composeMaxSum(List<Integer> arr) {
            List<Long> withoutMin = arr.stream()
                .map(element -> Long.valueOf(element.toString()))
                .sorted()
                .collect(Collectors.toList());

            Collections.reverse(withoutMin);

            withoutMin.remove(arr.size() - 1);

            Long sum = withoutMin.stream().reduce((long) 0, Long::sum);
            return Long.toString(sum);
        }
    }
}
