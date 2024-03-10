package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Alonelyinteger;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LonelyIntegerSolution {

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        bufferedReader.close();
        return String.valueOf(Result.lonelyinteger(a));
    }

    static class Result {

        /*
         * Complete the 'lonelyinteger' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY a as parameter.
         */

        public static int lonelyinteger(List<Integer> a) {
            Map<Integer, Integer> occurrences = new HashMap<>();
            for (Integer ele : a) {
                occurrences.put(ele, occurrences.getOrDefault(ele, 0) + 1);
            }
            return occurrences
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
        }
    }
}
