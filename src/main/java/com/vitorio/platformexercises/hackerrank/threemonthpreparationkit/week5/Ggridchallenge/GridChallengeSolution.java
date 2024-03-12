package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Ggridchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GridChallengeSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            IntStream.range(0, t).forEach(i -> {
                List<String> grid = new ArrayList<>();
                try {
                    int n = Integer.parseInt(bufferedReader.readLine());
                    IntStream.range(0, n).forEach(j -> {
                        try {
                            grid.add(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(Result.gridChallenge(grid));
            });
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'gridChallenge' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING_ARRAY grid as parameter.
         */

        public static String gridChallenge(List<String> grid) {
            List<String> sortedRowsGrid = new ArrayList<>();
            int numRowVals = grid.get(0).length();

            for (String row : grid) {
                var arr = row.toCharArray();
                Arrays.sort(arr);
                sortedRowsGrid.add(new String(arr));
            }

            for (int column = 0; column < numRowVals; column++) {
                for (int row = 0; row < numRowVals - 1; row++) {
                    char cRow = sortedRowsGrid.get(row).toCharArray()[column];
                    char cNextRow = sortedRowsGrid.get(row+1).toCharArray()[column];
                    if (cNextRow < cRow) {
                        return "NO";
                    }
                }
            }

            return "YES";
        }
    }
}
