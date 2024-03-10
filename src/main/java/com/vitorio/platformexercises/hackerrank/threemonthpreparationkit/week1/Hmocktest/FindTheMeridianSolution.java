package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Hmocktest;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindTheMeridianSolution {

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        bufferedReader.close();
        return String.valueOf(Result.findMedian(arr));
    }

    static class Result {

        /*
         * Complete the 'findMedian' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static int findMedian(List<Integer> arr) {
            int middleElementIndex = (arr.size() / 2);
            return arr.stream().sorted().collect(toList()).get(middleElementIndex);
        }
    }
}
