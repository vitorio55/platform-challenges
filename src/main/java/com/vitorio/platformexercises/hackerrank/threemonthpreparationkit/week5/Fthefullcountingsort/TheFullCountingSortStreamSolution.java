package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Fthefullcountingsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheFullCountingSortStreamSolution extends TheFullCountingSortBaseMain {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    @Override
    public String countSort(List<List<String>> arr) {
        return IntStream.range(0, arr.size())
            .mapToObj(i -> {
                String v = arr.get(i).get(0);
                if (i < arr.size() / 2) {
                    return new ArrayList<>(List.of(v, "-"));
                } else {
                    return new ArrayList<>(List.of(v, arr.get(i).get(1)));
                }
            })
            .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.get(0))))
            .map(ele -> ele.get(1))
            .collect(Collectors.joining(" "));
    }
}
