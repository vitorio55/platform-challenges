package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Fthefullcountingsort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public abstract class TheFullCountingSortBaseMain {

    public String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<List<String>> arr = new ArrayList<>();
            IntStream.range(1, n + 1).forEach(i -> {
                String[] vals = new String[0];
                try {
                    vals = bufferedReader.readLine().split(" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                arr.add(new ArrayList<>(Arrays.asList(vals)));
            });
            return countSort(arr);
        }
    }

    public abstract String countSort(List<List<String>> arr);
}
