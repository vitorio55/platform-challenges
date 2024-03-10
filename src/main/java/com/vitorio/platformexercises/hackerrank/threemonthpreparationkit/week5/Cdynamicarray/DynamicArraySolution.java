package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Cdynamicarray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicArraySolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String[] split = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int q = Integer.parseInt(split[1]);

            List<List<Integer>> queries = new ArrayList<>();

            for (int i = 1; i < q +1; i++) {
                split = bufferedReader.readLine().split(" ");
                List<Integer> vals = new ArrayList<>();
                for (String s : split) {
                    vals.add(Integer.parseInt(s));
                }
                queries.add(vals);
            }
            Result.dynamicArray(n, queries).forEach(sb::append);
        }
        return sb.toString();
    }

    class Result {

        /*
         * Complete the 'dynamicArray' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY queries
         */

        public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
            final int QUERY_TYPE_1 = 1;
            final int TYPE_IDX = 0;
            final int X_IDX = 1;
            final int Y_IDX = 2;

            int lastAnswer = 0;
            int idx;

            List<Integer> answers = new ArrayList<>();
            List<List<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(new ArrayList<>());
            }

            for (List<Integer> q : queries) {
                int type = q.get(TYPE_IDX);

                idx = ((q.get(X_IDX) ^ lastAnswer) % n);
                List<Integer> currentArray = arr.get(idx);

                if (type == QUERY_TYPE_1) {
                    currentArray.add(q.get(Y_IDX));
                } else {
                    int sidx = q.get(Y_IDX) % currentArray.size();
                    lastAnswer = currentArray.get(sidx);
                    answers.add(lastAnswer);
                }
            }
            return answers;
        }
    }
}
