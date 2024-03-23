package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Eformingamagicsquare;

import java.util.Arrays;
import java.util.List;

public class FormingAMagicSquareMatricesOperationsSolution extends FormingAMagicSquareBaseMain {

    // ----------------- TODO TAGS:
    //   #invert array
    //   #transpose matrix
    //   #magic square

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    @Override
    public int formingMagicSquare(List<List<Integer>> s) {
        // There are only 8 possibilities for magic square of distinct values 1 to 9 to sum 15 everywhere
        // The magic constant MUST be 15:
        // 1 + 2 + 3 => M
        // 4 + 5 + 6 => M
        // 7 + 8 + 9 => M
        // 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 => 3M
        // 45 => 3M .... M = 15
        int[] answer = new int[8];
        int[][] baseMagicSquare = {{8,3,4},{1,5,9},{6,7,2}};
        final int ROWS = 3;
        final int COLUMNS = 3;

        // 8 1 6
        // 3 5 7
        // 4 9 2
        int[][] transposed = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                transposed[i][j] = baseMagicSquare[j][i];
            }
        }
        // 4 3 8
        // 9 5 1
        // 2 7 6
        int[][] mirrored = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                mirrored[i][j] = baseMagicSquare[i][COLUMNS - j - 1];
            }
        }
        // 6 1 8
        // 7 5 3
        // 2 9 4
        int[][] transposedMirrored = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                transposedMirrored[i][j] = transposed[i][COLUMNS - j - 1];
            }
        }
        // 2 7 6
        // 9 5 1
        // 4 3 8
        int[][] mirroredRowsInverted = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            System.arraycopy(mirrored[ROWS - i - 1], 0, mirroredRowsInverted[i], 0, COLUMNS);
        }
        // 2 9 4
        // 7 5 3
        // 6 1 8
        int[][] mirroredRowsInvertedTransposed = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                mirroredRowsInvertedTransposed[i][j] = mirroredRowsInverted[j][i];
            }
        }
        // 6 7 2
        // 1 5 9
        // 8 3 4
        int[][] rowsInverted = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            System.arraycopy(baseMagicSquare[ROWS - i - 1], 0, rowsInverted[i], 0, COLUMNS);
        }
        // 4 9 2
        // 3 5 7
        // 8 1 6
        int[][] transposedRowsInverted = new int[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            System.arraycopy(transposed[COLUMNS - 1 - i], 0, transposedRowsInverted[i], 0, COLUMNS);
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int num = s.get(i).get(j);
                answer[0] += Math.abs(num - baseMagicSquare[i][j]);
                answer[1] += Math.abs(num - transposed[i][j]);
                answer[2] += Math.abs(num - mirrored[i][j]);
                answer[3] += Math.abs(num - transposedMirrored[i][j]);
                answer[4] += Math.abs(num - mirroredRowsInverted[i][j]);
                answer[5] += Math.abs(num - mirroredRowsInvertedTransposed[i][j]);
                answer[6] += Math.abs(num - rowsInverted[i][j]);
                answer[7] += Math.abs(num - transposedRowsInverted[i][j]);
            }
        }
        Arrays.sort(answer);
        return answer[0];
    }
}
