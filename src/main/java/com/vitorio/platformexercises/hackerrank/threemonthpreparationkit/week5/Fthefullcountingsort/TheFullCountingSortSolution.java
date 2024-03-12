package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Fthefullcountingsort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheFullCountingSortSolution extends TheFullCountingSortBaseMain {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    @Override
    public String countSort(List<List<String>> arr) {
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> toDashes = new HashMap<>();
        for (int i = 0; i < arr.size() / 2; i++) {
            String k = arr.get(i).get(0) + arr.get(i).get(1);
            toDashes.put(k, toDashes.getOrDefault(k, 0) + 1);
        }

        Comparator<List<String>> c = Comparator.comparingInt(s -> Integer.parseInt(s.get(0)));
        arr.sort(c);

        for (List<String> strings : arr) {
            String s = strings.get(0) + strings.get(1);
            if (toDashes.containsKey(s)) {
                int val = toDashes.get(s);
                if (val > 0) {
                    toDashes.put(s, toDashes.get(s) - 1);
                    if (val == 1) {
                        toDashes.remove(s);
                    }
                }
                sb.append("- ");
                continue;
            }
            sb.append(strings.get(1)).append(" ");
        }

        return sb.toString().trim();
    }
}
