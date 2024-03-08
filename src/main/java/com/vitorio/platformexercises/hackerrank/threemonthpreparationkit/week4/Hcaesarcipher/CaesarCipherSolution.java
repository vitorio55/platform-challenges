package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Hcaesarcipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CaesarCipherSolution {

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String l = bufferedReader.readLine();
            String s = bufferedReader.readLine();
            int k = Integer.parseInt(bufferedReader.readLine());
            return Result.caesarCipher(s, k);
        }
    }

    class Result {

        /*
         * Complete the 'caesarCipher' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. INTEGER k
         */

        public static String caesarCipher(String s, int k) {
            Queue<Character> letters = new LinkedList<>();
            Map<Character, Character> translationMap = new HashMap<>();

            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < alphabet.length(); i++) {
                char c = alphabet.charAt(i);
                letters.add(c);
            }
            for (int i = 0; i < k; i++) {
                letters.add(letters.poll());
            }
            for (int i = 0; i < alphabet.length(); i++) {
                translationMap.put(alphabet.charAt(i), letters.poll());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!Character.isAlphabetic(c)) {
                    sb.append(c);
                    continue;
                }
                char newC = translationMap.get(Character.toLowerCase(c));
                sb.append(Character.isLowerCase(c) ? newC : Character.toUpperCase(newC));
            }
            return sb.toString();
        }
    }
}
