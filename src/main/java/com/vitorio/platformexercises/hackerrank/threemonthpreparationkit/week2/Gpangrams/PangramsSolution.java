package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week2.Gpangrams;

import java.io.*;

public class PangramsSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String s = bufferedReader.readLine();
            return Result.pangrams(s);
        }
    }

    class Result {

        /*
         * Complete the 'pangrams' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */

        public static String pangrams(String s) {
            // Write your code here
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String normalized = s.toLowerCase();
            for (int i = 0; i < alphabet.length(); i++) {
                Character alphabetLetter = Character.toLowerCase(alphabet.charAt(i));
                if (normalized.indexOf(alphabetLetter) == -1) {
                    return "not pangram";
                }
            }
            return "pangram";
        }
    }
}
