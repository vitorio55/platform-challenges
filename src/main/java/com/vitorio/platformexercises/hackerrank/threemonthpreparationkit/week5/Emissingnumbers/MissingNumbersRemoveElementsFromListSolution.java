package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Emissingnumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class MissingNumbersRemoveElementsFromListSolution extends MissingNumbersBaseMain {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    @Override
    public List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        for (Integer i : arr) {
            brr.remove(i);
        }
        Set<Integer> result = new HashSet<>(brr);
        return result.stream().sorted().collect(toList());
    }
}
