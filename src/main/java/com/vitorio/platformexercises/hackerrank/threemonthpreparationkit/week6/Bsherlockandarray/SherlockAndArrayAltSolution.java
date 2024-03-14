package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Bsherlockandarray;

import java.util.List;

public class SherlockAndArrayAltSolution extends SherlockAndArrayBaseMain {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    @Override
    public String balancedSums(List<Integer> arr) {
        int rightSum = arr.stream().reduce(0, Integer::sum);
        int leftSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            leftSum += i == 0 ? 0 : arr.get(i - 1);
            rightSum -= arr.get(i);
            if (leftSum == rightSum) {
                return "YES";
            }
        }
        return "NO";
    }
}
