package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Dbreakingtherecords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BreakingTheRecordsSolution {
    public static List<Integer> main(String[] args) throws IOException {
        int n = Integer.parseInt(args[0]);

        List<Integer> scores = Stream.of(args[1].replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        return Result.breakingRecords(scores);
    }

    class Result {

        /*
         * Complete the 'breakingRecords' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY scores as parameter.
         */

        public static List<Integer> breakingRecords(List<Integer> scores) {
            // Write your code here
            int recordLowest = scores.get(0);
            int recordHighest = scores.get(0);
            int lowestBrokenTimes = 0;
            int highestBrokenTimes = 0;

            for (Integer s : scores) {
                if (s < recordLowest) {
                    recordLowest = s;
                    lowestBrokenTimes++;
                } else if (s > recordHighest) {
                    recordHighest = s;
                    highestBrokenTimes++;
                }
            }

            List<Integer> brokenRecordsCount = new ArrayList<>();
            brokenRecordsCount.add(highestBrokenTimes);
            brokenRecordsCount.add(lowestBrokenTimes);

            System.out.println(brokenRecordsCount);

            return brokenRecordsCount;
        }
    }
}
