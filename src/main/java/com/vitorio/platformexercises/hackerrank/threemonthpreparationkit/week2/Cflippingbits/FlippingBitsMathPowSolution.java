package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Cflippingbits;

import java.io.*;
import java.util.stream.IntStream;

public class FlippingBitsMathPowSolution {

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                sb.append(Result.flippingBits(n));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        return sb.toString();
    }

    class Result {

        /*
         * Complete the 'flippingBits' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts LONG_INTEGER n as parameter.
         */

        public static long flippingBits(long n) {
            // Solution submitted by user: kofiganoh
            // The bitwise complement of any integer N is equal to -(N + 1)
            return (long) (Math.pow(2, 32) - (n + 1));
        }
    }
}
