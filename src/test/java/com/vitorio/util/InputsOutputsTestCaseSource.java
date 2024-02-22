package com.vitorio.util;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputsOutputsTestCaseSource {

    public static Stream<Arguments> inputsOutputsSource(String filter, int cases) {
        var argsStream = IntStream.range(0, cases).mapToObj(i -> Arguments.of(
            "case" + i + "/input.txt", "case" + i + "/output.txt")
        );
        if (filter.isBlank()) {
            return argsStream;
        }
        return argsStream.filter(a -> a.get()[0].toString().contains(filter));
    }
}
