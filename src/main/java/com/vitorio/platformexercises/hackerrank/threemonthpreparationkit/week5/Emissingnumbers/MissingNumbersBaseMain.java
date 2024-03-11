package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Emissingnumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class MissingNumbersBaseMain {

    public String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Integer> arr = Stream.of(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            int m = Integer.parseInt(bufferedReader.readLine());
            List<Integer> brr = Stream.of(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            List<Integer> result = missingNumbers(arr, brr);
            for (Integer i : result) {
                sb.append(i).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public abstract List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr);
}
