package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Gzigzagsequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ZigZagSequenceSolution {

    // This is a debug challenge. We must maintain the code as is and only change some lines.

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine().trim());
            for (int cs = 1; cs <= t; cs++) {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                int[] a = new int[n];
                String[] vals = bufferedReader.readLine().trim().split(" ");
                IntStream.range(0, n).forEach(i -> a[i] = Integer.parseInt(vals[i]));
                sb.append(Result.findZigZagSequence(a, n));
            }
            return sb.toString();
        }
    }

    static class Result {

        public static String findZigZagSequence(int[] a, int n) {
            StringBuilder sb = new StringBuilder();

            Arrays.sort(a);
            // Change highest to middle array position
            //int mid = (n + 1) / 2;
            int mid = (n + 1) / 2 - 1;
            int temp = a[mid];
            a[mid] = a[n - 1];
            a[n - 1] = temp;

            int st = mid + 1;
            //int ed = n - 1;
            int ed = n - 2;
            while (st <= ed) {
                temp = a[st];
                a[st] = a[ed];
                a[ed] = temp;
                st = st + 1;
                //ed = ed + 1;
                ed = ed - 1;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(" ");
                sb.append(a[i]);
            }
            return sb.toString();
        }

        // According to challenge description (Java 8)
        public static void base_zigZagSequence(int[] a, int n) {
            Arrays.sort(a);
            int mid = (n + 1) / 2;
            int temp = a[mid];
            a[mid] = a[n - 1];
            a[n - 1] = temp;

            int st = mid + 1;
            int ed = n - 1;
            while (st <= ed) {
                temp = a[st];
                a[st] = a[ed];
                a[ed] = temp;
                st = st + 1;
                ed = ed + 1;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println();
        }
    }
}
