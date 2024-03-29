package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Hsumvsxor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumVsXorSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            long n = Long.parseLong(bufferedReader.readLine().trim());
            sb.append(Result.sumXor(n));
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'sumXor' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts LONG_INTEGER n as parameter.
         */

        public static long sumXor(long n) {
            if (n == 0) {
                // n + i = n ^ i
                // 0 + 0 = 0 ^ 0 -> only case
                return 1;
            }

            // For any number this is true, so start at 1:
            // n + 0 = n ^ 0
            long cases = 1;

            String bin = Long.toBinaryString(n);
            for (char c : bin.toCharArray()) {
                if (c != '0') {
                    continue;
                }
                cases *= 2;
            }
            return cases;
        }
    }
}
