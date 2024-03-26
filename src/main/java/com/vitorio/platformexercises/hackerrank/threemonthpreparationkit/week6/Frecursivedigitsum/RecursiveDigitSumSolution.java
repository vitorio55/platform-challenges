package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Frecursivedigitsum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RecursiveDigitSumSolution {

    // ----------------- TODO TAGS:
    //   #recursion

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        String[] vals = bufferedReader.readLine().split(" ");
        String n = vals[0].trim();
        int k = Integer.parseInt(vals[1].trim());
        bufferedReader.close();
        return String.valueOf(Result.superDigit(n, k));
    }

    static class Result {

        /*
         * Complete the 'superDigit' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING n
         *  2. INTEGER k
         */

        public static int superDigit(String n, int k) {
            if (n.length() == 1) {
                return Integer.parseInt(n);
            }
            long sum = 0;
            for (char c : n.toCharArray()) {
                sum += c - '0';
            }
            return superDigit(String.valueOf(sum * k), 1);
        }
    }
}
