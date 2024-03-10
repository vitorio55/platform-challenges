package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Eclosestnumbers;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ClosestNumbersSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            Result.closestNumbers(arr).forEach(v -> sb.append(v).append(" "));
        }
        return sb.toString().trim();
    }

    static class Result {

        /*
         * Complete the 'closestNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static List<Integer> closestNumbers(List<Integer> arr) {
            int smallestAbsoluteDifference = Integer.MAX_VALUE;

            List<Integer> aux = new ArrayList<>(arr);
            aux.sort(Comparator.naturalOrder());

            List<Integer> pairs = new ArrayList<>();

            for (int i = 0; i < aux.size() - 1; i++) {
                int val1 = aux.get(i);
                int val2 = aux.get(i + 1);
                int diff = val2 - val1;
                if (diff < smallestAbsoluteDifference) {
                    smallestAbsoluteDifference = diff;
                    // New smallest absolute difference, we must remove previously thought as smallest abs diff
                    pairs.clear();
                    pairs.add(aux.get(i));
                    pairs.add(aux.get(i + 1));
                }
                else if (diff == smallestAbsoluteDifference) {
                    pairs.add(aux.get(i));
                    pairs.add(aux.get(i + 1));
                }
            }
            return pairs;
        }

    }
}
