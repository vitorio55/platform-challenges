package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Hmarsexploration;

import java.io.*;

public class MarsExplorationSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String s = bufferedReader.readLine();
            return String.valueOf(Result.marsExploration(s));
        }
    }

    class Result {

        /*
         * Complete the 'marsExploration' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int marsExploration(String s) {
            int changedLetters = 0;
            char[] sos = {'S', 'O', 'S'};
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != sos[i % 3]) {
                    changedLetters++;
                }
            }
            return changedLetters;
        }
    }
}
