package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Bgradingstudents;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GradingStudentsSolution {

    // ----------------- TODO TAGS:
    //   #round to next multiple

    public static String main(File input) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine().replaceAll("\\s+$", "");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
        bufferedReader.close();
        StringBuilder sb = new StringBuilder();
        List<Integer> result = Result.gradingStudents(grades);
        result.forEach(sb::append);
        return sb.toString();
    }

    class Result {
        /*
         * Complete the 'gradingStudents' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts INTEGER_ARRAY grades as parameter.
         */

        public static List<Integer> gradingStudents(List<Integer> grades) {
            final int ROUND_NEAREST_TO_MULTIPLE_OF = 5;
            return grades.stream()
                .map(g -> {
                    if (g < 38) {
                        return g;
                    }
                    int difference = ROUND_NEAREST_TO_MULTIPLE_OF - g % ROUND_NEAREST_TO_MULTIPLE_OF;
                    return difference < 3 ? (g + difference) : g;
                })
                .collect(toList());
        }
    }
}
