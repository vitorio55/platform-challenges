package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Gcountergame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

public class CounterGameSolution {

    // ----------------- TODO TAGS:
    //   #log2
    //   #recursion

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, t).forEach(i -> {
            int n = 0;
            try {
                n = Integer.parseInt(bufferedReader.readLine().trim());
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(Result.counterGame(n));
        });

        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'counterGame' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts LONG_INTEGER n as parameter.
         */

        public static String counterGame(long n) {
            if (n == 1) {
                return "Richard";
            }
            long aux = n;
            String player = "Louise";
            while (true) {
                if (isPowerOfTwo(aux)) {
                    aux /= 2;
                } else {
                    aux -= nextPowerOfTwo(aux);
                }
                if (aux == 1) {
                    return player;
                }
                player = player.equals("Louise") ? "Richard" : "Louise";
            }
        }

        private static boolean isPowerOfTwo(long n) {
            if (n == 1) {
                return true;
            }
            if (n % 2 == 1) {
                return false;
            }
            return isPowerOfTwo(n / 2);
        }

        private static long nextPowerOfTwo(long aux) {
            if (aux == 1) {
                return 1;
            }
            // https://www.geeksforgeeks.org/how-to-calculate-log-base-2-of-an-integer-in-java/
            // 2^x = y   =>   x = log2(y)   =>   log2(y) is the same as (log10(y) / log10(2))
            double power = Math.log(aux) / Math.log(2);
            return (long) Math.pow(2, Math.floor(power));
        }
    }
}
