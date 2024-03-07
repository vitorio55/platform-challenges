package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Bleftrotation;

import java.io.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LeftRotationSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int d = Integer.parseInt(firstMultipleInput[1]);
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            Result.rotateLeft(d, arr).forEach(v -> sb.append(v).append(" "));
        }
        return sb.toString().trim();
    }

    class Result {

        /*
         * Complete the 'rotateLeft' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER d
         *  2. INTEGER_ARRAY arr
         */

        public static List<Integer> rotateLeft(int d, List<Integer> arr) {
            // Write your code here
            Stack<Integer> intStack = new Stack<>();
            Stack<Integer> auxStack = new Stack<>();

            for (int i = 0; i < d; i++) {
                intStack.push(arr.remove(0));
            }
            while (intStack.size() > 0) {
                auxStack.push(intStack.pop());
            }
            for (int i = 0; i < d; i++) {
                arr.add(auxStack.pop());
            }
            return arr;
        }
    }
}
