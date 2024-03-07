package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Cnumberlinejumps;

import java.io.*;

public class NumberLineJumpsSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int x1 = Integer.parseInt(firstMultipleInput[0]);
            int v1 = Integer.parseInt(firstMultipleInput[1]);
            int x2 = Integer.parseInt(firstMultipleInput[2]);
            int v2 = Integer.parseInt(firstMultipleInput[3]);
            return Result.kangaroo(x1, v1, x2, v2);
        }
    }

    class Result {

        /*
         * Complete the 'kangaroo' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. INTEGER x1
         *  2. INTEGER v1
         *  3. INTEGER x2
         *  4. INTEGER v2
         */

        public static String kangaroo(int x1, int v1, int x2, int v2) {
            // Write your code here
            final int MAX_DISTANCE = 10000;

            for (int i = 0; i < MAX_DISTANCE; i++) {
                if (x1 + (i * v1) == x2 + (i * v2)) return "YES";
            }
            return "NO";
        }
    }
}
