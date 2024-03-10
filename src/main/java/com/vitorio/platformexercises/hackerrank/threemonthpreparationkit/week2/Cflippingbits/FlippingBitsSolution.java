package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Cflippingbits;

import java.io.*;
import java.math.BigInteger;
import java.util.stream.IntStream;

public class FlippingBitsSolution {

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

    static class Result {

        /*
         * Complete the 'flippingBits' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts LONG_INTEGER n as parameter.
         */

        public static long flippingBits(long n) {
            int inverted = longToInvertedInt(n);
            String binStr = Integer.toBinaryString(inverted);
            return parseLongFromBinString(binStr);
        }

        private static int longToInvertedInt(long n) {
            int aux = (int) n;
            return ~aux;
        }

        private static long parseLongFromBinString(String s) {
            int base = 2;
            return new BigInteger(s, base).longValue();
        }
    }
}
