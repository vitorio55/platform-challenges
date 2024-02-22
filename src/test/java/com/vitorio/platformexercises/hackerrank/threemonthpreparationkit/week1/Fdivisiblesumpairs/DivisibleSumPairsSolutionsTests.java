package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Fdivisiblesumpairs;

import com.vitorio.util.InputOutputFileReader;
import com.vitorio.util.InputsOutputsTestCaseSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class DivisibleSumPairsSolutionsTests {

    private static final int INPUTS_AND_OUTPUTS = 1;
    private InputOutputFileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new InputOutputFileReader(
            "/platformexercises/hackerrank/threemonthpreparationkit/week1/Fdivisiblesumpairs/"
        );
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution(String input, String output) throws IOException {
        // Given
        String[] inputContent = fileReader.readFileContent(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        int result = DivisibleSumPairsSolution.main(inputContent);

        // Then
        Assertions.assertEquals(Integer.parseInt(expected.toString()), result);
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return InputsOutputsTestCaseSource.inputsOutputsSource("", INPUTS_AND_OUTPUTS);
    }
}
