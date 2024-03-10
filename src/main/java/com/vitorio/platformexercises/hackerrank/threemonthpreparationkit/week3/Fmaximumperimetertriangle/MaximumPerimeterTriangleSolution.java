package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Fmaximumperimetertriangle;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MaximumPerimeterTriangleSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            Result.maximumPerimeterTriangle(sticks).forEach(t -> sb.append(t).append(" "));
            return sb.toString().trim();
        }
    }

    static class Result {

        /*
         * Complete the 'maximumPerimeterTriangle' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY sticks as parameter.
         */

        /*
         * Complete the 'maximumPerimeterTriangle' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY sticks as parameter.
         */

        public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
            // Explanation:
            // By...
            //      ...ordering the list of sticks by ascending values and
            //      ...moving backwards in the list
            // We assure that these constraints are met:
            // 1- Choose the one with the longest maximum side.
            //    Comment: We first find the ones with the longest maximum side
            // 2- If more than one has that maximum, choose from them the one with the longest minimum side.
            //    Comment: We first find the ones with the longest minimum side
            // 3- If more than one has that maximum as well, print any one them.

            sticks.sort(Integer::compareTo);
            for (int i = sticks.size() - 1; i >= 2; i--) {
                int longestSide = sticks.get(i);
                int mediumSide = sticks.get(i - 1);
                int shortestSide = sticks.get(i - 2);
                if (longestSide < mediumSide + shortestSide) {
                    return Stream.of(shortestSide, mediumSide, longestSide).collect(toList());
                }
            }
            return List.of(-1);
        }
    }
}
