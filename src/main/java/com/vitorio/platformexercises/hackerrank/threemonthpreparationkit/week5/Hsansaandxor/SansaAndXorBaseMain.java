package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Hsansaandxor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public abstract class SansaAndXorBaseMain {

    public String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            IntStream.range(0, t).forEach(i -> {
                try {
                    int n = Integer.parseInt(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                List<Integer> arr = null;
                try {
                    arr = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).toList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(sansaXor(arr));
            });
        }
        return sb.toString();
    }

    public abstract int sansaXor(List<Integer> arr);
}
