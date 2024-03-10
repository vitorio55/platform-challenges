package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Dseparatethenumbers;

import java.io.*;
import java.util.stream.IntStream;

public class SeparateTheNumbersSolution {

    // https://www.geeksforgeeks.org/consecutive-sequenced-numbers-in-a-string/

    // ----------------- TODO TAGS:
    //   #string projection

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String s = bufferedReader.readLine();
                    sb.append(Result.separateNumbers(s));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'separateNumbers' function below.
         *
         * The function accepts STRING s as parameter.
         */

        public static String separateNumbers(String s) {
            StringBuilder sb = new StringBuilder();
            long numeric;
            long first = 0;

            boolean isBeautiful = true;

            if (s.length() == 1) {
                return "NO";
            }

            for (int i = 1; i <= s.length() / 2; i++) {
                // Get current string
                sb.delete(0, sb.length());
                sb.append(s, 0, i); // Only up until half of the string

                // Get numeric value of current string
                numeric = Long.parseLong(sb.toString());
                first = numeric;

                // Check if at any point the string diverges from expected
                while (sb.toString().length() < s.length()) {
                    sb.append(++numeric);
                    if (!s.startsWith(sb.toString())) {
                        isBeautiful = false;
                        break;
                    }
                }
                // Check if string is beautiful at the present moment
                if (sb.toString().equals(s)) {
                    isBeautiful = true;
                    break;
                }
            }
            // Display results
            if (isBeautiful) {
                return "YES " + first;
            }
            else {
                return "NO";
            }
        }
    }
}
