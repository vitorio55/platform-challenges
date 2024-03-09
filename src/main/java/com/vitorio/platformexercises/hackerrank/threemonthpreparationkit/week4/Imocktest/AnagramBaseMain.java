package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week4.Imocktest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

public abstract class AnagramBaseMain {

    public String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int t = Integer.parseInt(bufferedReader.readLine());
            IntStream.range(1, t + 1).forEach(qItr -> {
                String s = null;
                try {
                    s = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(anagram(s));
            });

        }
        return sb.toString();
    }

    public abstract int anagram(String s);
}
