package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Imocktest;

public class AnagramArrayOfChangeLettersSumSolution extends AnagramBaseMain {

    // https://www.geeksforgeeks.org/minimum-number-of-manipulations-required-to-make-two-strings-anagram-without-deletion-of-character/

    // ----------------- TODO TAGS:
    //   #anagram

    @Override
    public int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }

        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);

        int count = 0;

        // store the count of character
        int char_count[] = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < firstHalf.length(); i++) {
            char_count[firstHalf.charAt(i) - 'a']++;
        }

        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < secondHalf.length(); i++) {
            char_count[secondHalf.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; ++i) {
            if (char_count[i] != 0) {
                count+= Math.abs(char_count[i]);
            }
        }

        return count / 2;
    }
}
