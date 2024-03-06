package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Imocktest;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BetweenTwoSetsSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            sb.append(Result.getTotalX(arr, brr));
        }
        return sb.toString();
    }

    class Result {

        /*
         * Complete the 'getTotalX' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY a
         *  2. INTEGER_ARRAY b
         */

        public static int getTotalX(List<Integer> a, List<Integer> b) {
            int count = 0;

            for (int i = 1; i <= 100; i++) {
                boolean broke = false;
                for (Integer valInA : a) {
                    if (i % valInA != 0) {
                        broke = true;
                        break;
                    }
                }
                if (broke) continue;
                for (Integer valInB : b) {
                    if (valInB % i != 0) {
                        broke = true;
                        break;
                    }
                }
                if (broke) continue;
                count++;
            }
            return count;
        }
    }
}
