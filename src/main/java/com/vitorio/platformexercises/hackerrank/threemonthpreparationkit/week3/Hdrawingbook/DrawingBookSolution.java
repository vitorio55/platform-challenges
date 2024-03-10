package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Hdrawingbook;

import java.io.*;

public class DrawingBookSolution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            int p = Integer.parseInt(bufferedReader.readLine().trim());
            sb.append(Result.pageCount(n, p));
        }
        return sb.toString();
    }

    static class Result {

        /*
         * Complete the 'pageCount' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER p
         */

        public static int pageCount(int n, int p) {
            // Submitted by user: Locking_Will
            // I added some explanatory comments

            int pagesInTheBook = n;
            int pageToReach = p;

            // We need to bring to the closest odd integer because:
            //  - since we are using ints, the division will always be rounded down
            //  - e.g. 6 pages total and we need to reach page 5 => coming from the end, (6 - 5) / 2 = 1 / 2 => rounds down to 0
            //    when we need ((6+1) - 5) / 2 = 2 / 2 = 1
            if (pagesInTheBook % 2 == 0) ++pagesInTheBook;

            // Moving from end, we need to only get to the desired number, therefore we exclude the pages from start
            // until desired page.
            // Also each 2 values means 1 page flip just like counting from the start
            int fromBack = (pagesInTheBook - pageToReach)/2;

            // Moving from start, each 2 values means 1 page flip
            // Therefore, number of page flips is (desired page / 2)
            int fromFront = pageToReach/2;

            return Math.min(fromBack, fromFront);
        }
    }
}
