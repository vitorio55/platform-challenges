package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Ftowerbreakers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

public class TowerBreakersShortSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(1, t + 1).forEach(tItr -> {
                String[] multipleInput = new String[0];
                try {
                    multipleInput = bufferedReader.readLine().trim().replaceAll("\\s+$", "").split(" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int n = Integer.parseInt(multipleInput[0]);
                int m = Integer.parseInt(multipleInput[1]);
                sb.append(Result.towerBreakers(n, m));
            });
        }
        return sb.toString();
    }

    public class Result {

        /*
         * Complete the 'towerBreakers' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER m
         */

        public static int towerBreakers(int n, int m) {
            // Submitted by user: gl018901
            return (n % 2 == 0 || m == 1) ? 2 : 1;
        }
    }
}
