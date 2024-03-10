package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Imocktest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlippingTheMatrixSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, q).forEach(qItr -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine().trim());
                    List<List<Integer>> matrix = new ArrayList<>();
                    IntStream.range(0, 2 * n).forEach(i -> {
                        try {
                            matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                            );
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    sb.append(Result.flippingMatrix(matrix));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'flippingMatrix' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
         */

        public static int flippingMatrix(List<List<Integer>> matrix) {
            int sum = 0;
            int rows = matrix.size();
            int maxIPossible = rows - 1;
            int columns = matrix.get(0).size();
            int maxJPossible = columns - 1;

            for (int i = 0; i < rows / 2; i++) {
                for (int j = 0; j < columns / 2; j++) {
                    // We can replace current cell [i, j] with 4 other cells
                    // --------------------
                    // We should compare to get MAX out of these
                    // A    B  C  D
                    // [E]  F  G  [H]
                    // [I]  J  K  [L]
                    // M    N  O  P
                    //
                    // ...then these and so on:
                    // [A] B  C  [D]
                    // E   F  G  H
                    // I   J  K  L
                    // [M] N  O  [P]

                    int atTop = matrix.get(i).get(j);
                    int atBottom = matrix.get(maxIPossible - i).get(j);
                    int maxLeft = Math.max(atTop, atBottom);

                    atBottom = matrix.get(maxIPossible - i).get(maxJPossible - j);
                    atTop = matrix.get(i).get(maxJPossible - j);
                    int maxRight = Math.max(atTop, atBottom);

                    sum += Math.max(maxLeft, maxRight);
                }
            }
            return sum;
        }
    }
}