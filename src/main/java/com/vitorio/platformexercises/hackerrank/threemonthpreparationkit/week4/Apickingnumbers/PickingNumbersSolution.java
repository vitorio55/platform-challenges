package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Apickingnumbers;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PickingNumbersSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            return String.valueOf(Result.pickingNumbers(a));
        }
    }

    static class Result {

        /*
         * Complete the 'pickingNumbers' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY a as parameter.
         */

        public static int pickingNumbers(List<Integer> a) {
            Collections.sort(a);

            int lowestInWindow = Integer.MAX_VALUE;
            int highestInWindow = Integer.MIN_VALUE;
            int largestSubArrayLen = 2;

            int back = 0;
            for (int front = 1; front < a.size(); ) {
                int valBack = a.get(back);
                int valFront = a.get(front);
                lowestInWindow = Math.min(lowestInWindow, valBack);
                lowestInWindow = Math.min(lowestInWindow, valFront);
                highestInWindow = Math.max(highestInWindow, valBack);
                highestInWindow = Math.max(highestInWindow, valFront);

                if (Math.abs(highestInWindow - lowestInWindow) > 1) {
                    back++;
                    front = Math.min(back + 1, a.size() - 1);
                    lowestInWindow = Math.min(a.get(back), a.get(front));
                    highestInWindow = Math.max(a.get(back), a.get(front));
                } else {
                    largestSubArrayLen = Math.max(largestSubArrayLen, front - back + 1);
                    front++;
                }
            }
            return largestSubArrayLen;
        }
    }
}
