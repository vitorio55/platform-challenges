package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Ddiagonaldifference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifferenceSolution {

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        return String.valueOf(Result.diagonalDifference(arr));
    }

    static class Result {

        /*
         * Complete the 'diagonalDifference' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */

        public static int diagonalDifference(List<List<Integer>> arr) {
            int rows = arr.size();
            int topLeftBottomRightDiagonalSum = 0;
            int topRightBottomLeftDiagonalSum = 0;

            for (int i = 0; i < rows; i++) {
                List<Integer> row = arr.get(i);
                topLeftBottomRightDiagonalSum += row.get(i);
                topRightBottomLeftDiagonalSum += row.get((rows - 1) - i);
            }

            return Math.abs(topLeftBottomRightDiagonalSum - topRightBottomLeftDiagonalSum);
        }
    }
}
