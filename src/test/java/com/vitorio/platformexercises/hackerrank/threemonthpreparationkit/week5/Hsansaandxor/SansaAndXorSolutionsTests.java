package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Hsansaandxor;

import com.vitorio.util.InputOutputFileReader;
import com.vitorio.util.InputsOutputsTestCaseSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class SansaAndXorSolutionsTests {

    private static final int INPUTS_AND_OUTPUTS = 4;
    private InputOutputFileReader fileReader;

    private final SansaAndXorIgnoringEvenFrequenciesSolution ignoringEvenFrequenciesSolution = new SansaAndXorIgnoringEvenFrequenciesSolution();
    private final SansaAndXorIgnoringOddIndexesSolution ignoringOddIndexesSolution = new SansaAndXorIgnoringOddIndexesSolution();

    @BeforeEach
    void setUp() {
        fileReader = new InputOutputFileReader(
            "/platformexercises/hackerrank/threemonthpreparationkit/week5/Hsansaandxor/"
        );
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution_IgnoringEvenFrequencies(String input, String output) throws IOException {
        // Given
        File inputContent = fileReader.fileFromFilePath(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        String actual = ignoringEvenFrequenciesSolution.main(inputContent);

        // Then
        Assertions.assertEquals(expected.toString(), actual);
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution_IgnoringOddIndexes(String input, String output) throws IOException {
        // Given
        File inputContent = fileReader.fileFromFilePath(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        String actual = ignoringOddIndexesSolution.main(inputContent);

        // Then
        Assertions.assertEquals(expected.toString(), actual);
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return InputsOutputsTestCaseSource.inputsOutputsSource("", INPUTS_AND_OUTPUTS);
    }
}
