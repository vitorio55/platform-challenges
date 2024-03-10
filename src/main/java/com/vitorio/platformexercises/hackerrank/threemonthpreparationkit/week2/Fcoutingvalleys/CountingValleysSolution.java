package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Fcoutingvalleys;

import java.io.*;

public class CountingValleysSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int steps = Integer.parseInt(bufferedReader.readLine().trim());
            String path = bufferedReader.readLine();
            return String.valueOf(Result.countingValleys(steps, path));
        }
    }

    static class Result {

        /*
         * Complete the 'countingValleys' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER steps
         *  2. STRING path
         */

        public static int countingValleys(int steps, String path) {
            int valleys = 0;
            int height = 0;
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'U') {
                    if (height == -1) {
                        valleys++;
                    }
                    height++;
                } else {
                    height--;
                }
            }
            return valleys;
        }
    }
}
