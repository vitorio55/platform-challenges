package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Ecountingsort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountingSortSolution {

    public static String main(File input) throws IOException {
        List<Integer> arr;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        }
        StringBuilder sb = new StringBuilder();
        Result.countingSort(arr).forEach(v -> sb.append(v).append(" "));
        return sb.toString().trim();
    }

    class Result {

        /*
         * Complete the 'countingSort' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> countingSort(List<Integer> arr) {
            final int ARRAY_SIZE = 100;
            int[] occurrences = new int[ARRAY_SIZE];
            for (Integer e : arr) {
                occurrences[e]++;
            }
            return IntStream.of(occurrences).boxed().collect(Collectors.toList());
        }
    }
}
