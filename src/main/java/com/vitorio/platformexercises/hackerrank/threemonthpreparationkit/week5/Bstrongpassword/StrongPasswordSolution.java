package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Bstrongpassword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StrongPasswordSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String password = bufferedReader.readLine();
            return String.valueOf(Result.minimumNumber(n, password));
        }
    }

    class Result {

        /*
         * Complete the 'minimumNumber' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. STRING password
         */

        public static int minimumNumber(int n, String password) {
            final int MIN_LEN = 6;
            final String NUMBERS = "0123456789";
            final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
            final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            final String SPECIAL_CHARS = "!@#$%^&*()-+";

            int requiredExtraChars = 0;

            boolean noNumbers = true;
            boolean noUpperCase = true;
            boolean noLowerCase = true;
            boolean noSpecialChar = true;

            for (char c : password.toCharArray()) {
                if (NUMBERS.indexOf(c) != -1) {
                    noNumbers = false;
                } else if (LOWER_CASE_LETTERS.indexOf(c) != -1) {
                    noLowerCase = false;
                } else if (UPPER_CASE_LETTERS.indexOf(c) != -1) {
                    noUpperCase = false;
                } else if (SPECIAL_CHARS.indexOf(c) != -1) {
                    noSpecialChar = false;
                }
            }
            if (noNumbers) requiredExtraChars++;
            if (noLowerCase) requiredExtraChars++;
            if (noUpperCase) requiredExtraChars++;
            if (noSpecialChar) requiredExtraChars++;
            return Math.max(requiredExtraChars, MIN_LEN - password.length());
        }
    }
}
