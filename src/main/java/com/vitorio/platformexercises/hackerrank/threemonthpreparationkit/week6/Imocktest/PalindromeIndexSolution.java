package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Imocktest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PalindromeIndexSolution {

    // ----------------- TODO TAGS:
    //   #palindrome

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<String> strings = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());
            strings.forEach(s -> sb.append(Result.palindromeIndex(s)));
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'palindromeIndex' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int palindromeIndex(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                char sc = s.charAt(start);
                char ec = s.charAt(end);
                if (sc != ec && isPalindromeFromIndexes(s, start + 1, end)) {
                    return start;
                } else if (sc != ec && isPalindromeFromIndexes(s, start, end - 1)) {
                    return end;
                }
                start++;
                end--;
            }
            return -1;
        }

        private static boolean isPalindromeFromIndexes(String str, int start, int end) {
            while (start < end) {
                char sc = str.charAt(start);
                char ec = str.charAt(end);
                if (sc != ec) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
