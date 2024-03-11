package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Emissingnumbers;

import java.util.*;

public class MissingNumbersSolution extends MissingNumbersBaseMain {

    @Override
    public List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Set<Integer> verified = new HashSet<>();
        List<Integer> missing = new ArrayList<>();

        arr.sort(Comparator.naturalOrder());
        brr.sort(Comparator.naturalOrder());

        Map<Integer, Integer> occurrencesInArr = new HashMap<>();
        Map<Integer, Integer> occurrencesInBrr = new HashMap<>();

        for (Integer i : arr) {
            occurrencesInArr.put(i, occurrencesInArr.getOrDefault(i, 0) + 1);
        }
        for (Integer i : brr) {
            occurrencesInBrr.put(i, occurrencesInBrr.getOrDefault(i, 0) + 1);
        }

        for (int val : brr) {
            if (verified.contains(val)) {
                continue;
            }
            boolean totallyMissing = !arr.contains(val);
            boolean timesDiffer = !Objects.equals(occurrencesInArr.get(val), occurrencesInBrr.get(val));
            if (totallyMissing || timesDiffer) {
                missing.add(val);
            }
            verified.add(val);
        }

        return missing;
    }
}
