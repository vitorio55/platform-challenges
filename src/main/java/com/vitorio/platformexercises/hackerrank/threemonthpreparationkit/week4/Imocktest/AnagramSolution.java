package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Imocktest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramSolution extends AnagramBaseMain {

    // ----------------- TODO TAGS:
    //   #anagram

    @Override
    public int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }

        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);

        Map<Character, Integer> lettersInFirstHalf = new HashMap<>();
        Map<Character, Integer> lettersInSecondHalf = new HashMap<>();

        int minChanges = 0;
        Set<Character> alreadyChecked = new HashSet<>();

        for (int i = 0; i < firstHalf.length(); i++) {
            char c = firstHalf.charAt(i);
            lettersInFirstHalf.put(c, lettersInFirstHalf.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < secondHalf.length(); i++) {
            char c = secondHalf.charAt(i);
            lettersInSecondHalf.put(c, lettersInSecondHalf.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < firstHalf.length(); i++) {
            char c = firstHalf.charAt(i);
            if (alreadyChecked.contains(c)) {
                continue;
            }

            int charCountInFirstHalf = lettersInFirstHalf.getOrDefault(c, 0);
            int charCountInSecondHalf = lettersInSecondHalf.getOrDefault(c, 0);
            if (charCountInFirstHalf == charCountInSecondHalf) {
                alreadyChecked.add(c);
                continue;
            }
            int sub = charCountInFirstHalf - charCountInSecondHalf;
            if (sub > 0) {
                minChanges += sub;
            }
            alreadyChecked.add(c);
        }
        return minChanges;
    }
}
