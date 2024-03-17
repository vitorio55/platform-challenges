package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Bsherlockandarray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class SherlockAndArrayBaseMain {

    public String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            StringBuilder sb = new StringBuilder();

            IntStream.range(0, t).forEach(i -> {
                List<Integer> arr = null;
                try {
                    int n = Integer.parseInt(bufferedReader.readLine());
                    arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(balancedSums(arr));
            });
            return sb.toString();
        }
    }

    public abstract String balancedSums(List<Integer> arr);
}
