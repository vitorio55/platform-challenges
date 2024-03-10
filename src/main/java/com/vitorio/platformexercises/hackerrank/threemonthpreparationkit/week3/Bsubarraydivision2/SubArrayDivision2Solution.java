package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Bsubarraydivision2;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SubArrayDivision2Solution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int d = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            sb.append(Result.birthday(s, d, m));
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'birthday' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY s
         *  2. INTEGER d
         *  3. INTEGER m
         */

        public static int birthday(List<Integer> s, int d, int m) {
            int ways = 0;
            int currentSum = 0;
            int chunkSize = m;
            int neededSum = d;
            for (int i = 0; i < chunkSize; i++) {
                currentSum += s.get(i);
            }
            if (currentSum == neededSum) {
                ways++;
            }
            for (int i = chunkSize; i < s.size(); i++) {
                int leftMost = s.get(i - chunkSize);
                int newElementOnTheRight = s.get(i);
                currentSum -= leftMost;
                currentSum += newElementOnTheRight;
                if (currentSum == neededSum) {
                    ways++;
                }
            }
            return ways;
        }
    }
}
