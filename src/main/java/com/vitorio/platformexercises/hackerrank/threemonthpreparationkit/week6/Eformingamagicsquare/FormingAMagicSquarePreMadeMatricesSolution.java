package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Eformingamagicsquare;

import java.util.Arrays;
import java.util.List;

public class FormingAMagicSquarePreMadeMatricesSolution extends FormingAMagicSquareBaseMain {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    @Override
    public int formingMagicSquare(List<List<Integer>> s) {
        int[] answer = new int[8];
        int[][] possibleMagicSquare1 = {{8,3,4},{1,5,9},{6,7,2}};
        int[][] possibleMagicSquare2 = {{8,1,6},{3,5,7},{4,9,2}};
        int[][] possibleMagicSquare3 = {{4,3,8},{9,5,1},{2,7,6}};
        int[][] possibleMagicSquare4 = {{6,1,8},{7,5,3},{2,9,4}};
        int[][] possibleMagicSquare5 = {{2,7,6},{9,5,1},{4,3,8}};
        int[][] possibleMagicSquare6 = {{2,9,4},{7,5,3},{6,1,8}};
        int[][] possibleMagicSquare7 = {{6,7,2},{1,5,9},{8,3,4}};
        int[][] possibleMagicSquare8 = {{4,9,2},{3,5,7},{8,1,6}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = s.get(i).get(j);
                answer[0] += Math.abs(num - possibleMagicSquare1[i][j]);
                answer[1] += Math.abs(num - possibleMagicSquare2[i][j]);
                answer[2] += Math.abs(num - possibleMagicSquare3[i][j]);
                answer[3] += Math.abs(num - possibleMagicSquare4[i][j]);
                answer[4] += Math.abs(num - possibleMagicSquare5[i][j]);
                answer[5] += Math.abs(num - possibleMagicSquare6[i][j]);
                answer[6] += Math.abs(num - possibleMagicSquare7[i][j]);
                answer[7] += Math.abs(num - possibleMagicSquare8[i][j]);
            }
        }
        Arrays.sort(answer);
        return answer[0];
    }
}
