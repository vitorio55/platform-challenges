package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Apermutingtwoarrays;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PermutingTwoArraysSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                    int n = Integer.parseInt(firstMultipleInput[0]);
                    int k = Integer.parseInt(firstMultipleInput[1]);
                    List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                    List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                    sb.append(Result.twoArrays(k, A, B));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'twoArrays' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY A
         *  3. INTEGER_ARRAY B
         */

        public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
            Collections.sort(A);
            Collections.sort(B);
            Collections.reverse(B);

            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) + B.get(i) < k) {
                    return "NO";
                }
            }
            return "YES";
        }
    }
}
