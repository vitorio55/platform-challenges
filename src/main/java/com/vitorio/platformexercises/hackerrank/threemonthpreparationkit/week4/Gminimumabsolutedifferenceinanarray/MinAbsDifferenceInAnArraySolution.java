package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Gminimumabsolutedifferenceinanarray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinAbsDifferenceInAnArraySolution {

    // ----------------- TODO TAGS:
    //   #minimum absolute difference

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            var vals = bufferedReader.readLine().split(" ");
            var list = Arrays.stream(vals).map(Integer::parseInt).toList();
            List<Integer> nums = new ArrayList<>(list);
            return String.valueOf(Result.minimumAbsoluteDifference(nums));
        }
    }

    class Result {

        /*
         * Complete the 'minimumAbsoluteDifference' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static int minimumAbsoluteDifference(List<Integer> arr) {
            arr.sort(Comparator.naturalOrder());

            int minimumAbsDifference = Integer.MAX_VALUE;

            for (int i = 0; i < arr.size() - 1; i++) {
                int diff = Math.abs(arr.get(i) - arr.get(i + 1));
                if (diff < minimumAbsDifference) {
                    minimumAbsDifference = diff;
                }
            }
            return minimumAbsDifference;
        }
    }
}
