package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week6.Eformingamagicsquare;

import com.vitorio.util.InputOutputFileReader;
import com.vitorio.util.InputsOutputsTestCaseSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class FormingAMagicSquareMatricesOperationsSolutionsTests {

    private static final int INPUTS_AND_OUTPUTS = 4;
    private InputOutputFileReader fileReader;

    private static final FormingAMagicSquareMatricesOperationsSolution matricesOperationsSolution = new FormingAMagicSquareMatricesOperationsSolution();
    private static final FormingAMagicSquarePreMadeMatricesSolution preMadeMatricesSolution = new FormingAMagicSquarePreMadeMatricesSolution();

    @BeforeEach
    void setUp() {
        fileReader = new InputOutputFileReader(
            "/platformexercises/hackerrank/threemonthpreparationkit/week6/Eformingamagicsquare/"
        );
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution_Matrices_Operations(String input, String output) throws IOException {
        // Given
        String[] inputContent = fileReader.readFileContent(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        int result = matricesOperationsSolution.main(inputContent);

        // When
        Assertions.assertEquals(expected.toString(), String.valueOf(result));
    }

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution_PreMade_Matrices(String input, String output) throws IOException {
        // Given
        String[] inputContent = fileReader.readFileContent(input);
        String[] outputContent = fileReader.readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s);
        }

        // When
        int result = preMadeMatricesSolution.main(inputContent);

        // When
        Assertions.assertEquals(expected.toString(), String.valueOf(result));
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return InputsOutputsTestCaseSource.inputsOutputsSource("", INPUTS_AND_OUTPUTS);
    }
}
