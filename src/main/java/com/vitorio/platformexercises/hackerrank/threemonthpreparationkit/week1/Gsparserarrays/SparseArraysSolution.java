package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Gsparserarrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SparseArraysSolution {

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        StringBuilder sb = new StringBuilder();
        List<Integer> result = Result.matchingStrings(strings, queries);
        result.forEach(sb::append);
        bufferedReader.close();
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'matchingStrings' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. STRING_ARRAY strings
         *  2. STRING_ARRAY queries
         */

        public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
            Map<String, Integer> occurrences = new LinkedHashMap<>();
            List<Integer> result = new ArrayList<>();

            for (String string : strings) {
                if (occurrences.containsKey(string)) {
                    occurrences.put(string, occurrences.get(string) + 1);
                } else {
                    occurrences.put(string, 1);
                }
            }
            for (String query : queries) {
                result.add(occurrences.getOrDefault(query, 0));
            }

            return result;
        }
    }
}
