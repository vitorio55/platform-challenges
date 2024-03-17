package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Cmiserenim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MisereNimSolution {

    // ----------------- TODO TAGS:
    //   #nim
    //   #xor

    // Nim:
    // https://en.wikipedia.org/wiki/Nim

    // For XOR clarity, see:
    // https://www.quora.com/How-do-I-solve-the-game-of-Nim

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            IntStream.range(0, t).forEach(i -> {
                List<Integer> arr = null;
                try {
                    int n = Integer.parseInt(bufferedReader.readLine());
                    arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(Result.misereNim(arr));
            });
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'misereNim' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts INTEGER_ARRAY s as parameter.
         */

        public static String misereNim(List<Integer> s) {
            // Transcribed to Java from Hackerrank's editorial (in python)

            // If only stacks of '1' we can check if odd or even for defining the winning player
            Set<Integer> nums = new HashSet<>(s);
            if (nums.size() == 1 && nums.contains(1)) {
                return s.size() % 2 == 0 ? "First" : "Second";
            }

            // If stacks of different sizes, we can apply the XOR sum to define the winning player
            int x = 0;
            for (Integer num : s) {
                x ^= num;
            }
            // If initial XOR is zero, first player WILL lose
            return x > 0 ? "First" : "Second";
        }
    }
}
