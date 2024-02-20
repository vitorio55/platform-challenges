package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Dbreakingtherecords;

import com.vitorio.util.InputOutputFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class BreakingTheRecordsSolutionsTests {

    private InputOutputFileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new InputOutputFileReader(
            "/platformexercises/hackerrank/threemonthpreparationkit/week1/Dbreakingtherecords/"
        );
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution(String input, String output) throws IOException {
        String[] inputContent = fileReader.readFileContent(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        List<Integer> result = BreakingTheRecordsSolution.main(inputContent);
        StringBuilder actual = new StringBuilder();
        result.forEach(i -> actual.append(i).append(" "));

        Assertions.assertEquals(expected.toString(), actual.toString().trim());
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return Stream.of(
            Arguments.of("case0/input.txt", "case0/output.txt"),
            Arguments.of("case1/input.txt", "case1/output.txt"),
            Arguments.of("case2/input.txt", "case2/output.txt")
        );
    }
}
