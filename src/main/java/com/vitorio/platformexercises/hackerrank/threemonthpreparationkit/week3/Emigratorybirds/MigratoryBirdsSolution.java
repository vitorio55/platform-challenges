package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Emigratorybirds;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MigratoryBirdsSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            return String.valueOf(Result.migratoryBirds(arr));
        }
    }

    static class Result {

        /*
         * Complete the 'migratoryBirds' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static int migratoryBirds(List<Integer> arr) {
            final int BIRD_TYPES = 5;
            int[] birds = new int[BIRD_TYPES];
            for (int i : arr) {
                birds[i-1]++;
            }
            int maxSightingsType = 0;
            int maxSightings = Integer.MIN_VALUE;
            for (int i = BIRD_TYPES - 1; i >= 0; i--) {
                if (birds[i] >= maxSightings) {
                    maxSightings = birds[i];
                    maxSightingsType = i;
                }
            }
            return maxSightingsType + 1;
        }
    }
}
