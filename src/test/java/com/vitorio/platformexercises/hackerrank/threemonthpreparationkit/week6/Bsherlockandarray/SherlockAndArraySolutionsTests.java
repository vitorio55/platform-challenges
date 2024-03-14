package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Bsherlockandarray;

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

public class SherlockAndArraySolutionsTests {

    private static final int INPUTS_AND_OUTPUTS = 4;
    private InputOutputFileReader fileReader;

    private final SherlockAndArraySolution solution = new SherlockAndArraySolution();
    private final SherlockAndArrayAltSolution altSolution = new SherlockAndArrayAltSolution();

    @BeforeEach
    void setUp() {
        fileReader = new InputOutputFileReader(
            "/platformexercises/hackerrank/threemonthpreparationkit/week6/Bsherlockandarray/"
        );
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution(String input, String output) throws IOException {
        // Given
        File inputContent = fileReader.fileFromFilePath(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        String actual = solution.main(inputContent);

        // Then
        Assertions.assertEquals(expected.toString(), actual);
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution_Alt(String input, String output) throws IOException {
        // Given
        File inputContent = fileReader.fileFromFilePath(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        String actual = altSolution.main(inputContent);

        // Then
        Assertions.assertEquals(expected.toString(), actual);
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return InputsOutputsTestCaseSource.inputsOutputsSource("", INPUTS_AND_OUTPUTS);
    }
}
