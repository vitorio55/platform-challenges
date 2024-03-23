package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Eformingamagicsquare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public abstract class FormingAMagicSquareBaseMain {

    public int main(String[] args) throws IOException {
        List<List<Integer>> square = new ArrayList<>();

        for (String arg : args) {
            List<Integer> row = Stream.of(arg.replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            square.add(row);
        }
        return formingMagicSquare(square);
    }

    public abstract int formingMagicSquare(List<List<Integer>> s);
}
