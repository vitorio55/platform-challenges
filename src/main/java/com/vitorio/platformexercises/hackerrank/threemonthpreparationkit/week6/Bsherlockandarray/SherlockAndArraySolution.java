package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Bsherlockandarray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SherlockAndArraySolution extends SherlockAndArrayBaseMain {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    @Override
    public String balancedSums(List<Integer> arr) {
        List<Integer> sumsToTheLeft = new ArrayList<>();
        sumsToTheLeft.add(0);
        List<Integer> sumsToTheRight = new ArrayList<>();

        int sumSoFar = 0;
        for (int i = 1; i < arr.size(); i++) {
            sumSoFar += arr.get(i - 1);
            sumsToTheLeft.add(sumSoFar);
        }

        sumSoFar = 0;
        for (int i = arr.size() - 2; i >= 0; i--) {
            sumSoFar += arr.get(i + 1);
            sumsToTheRight.add(sumSoFar);
        }

        sumsToTheRight.sort(Comparator.reverseOrder());
        sumsToTheRight.add(0);

        for (int i = 0; i < arr.size(); i++) {
            if (sumsToTheLeft.get(i).equals(sumsToTheRight.get(i))) {
                return "YES";
            }
        }

        return "NO";
    }
}
