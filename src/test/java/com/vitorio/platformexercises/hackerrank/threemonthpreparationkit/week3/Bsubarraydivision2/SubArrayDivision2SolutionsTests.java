package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Bsubarraydivision2;

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

public class SubArrayDivision2SolutionsTests {

    private static final int INPUTS_AND_OUTPUTS = 6;
    private InputOutputFileReader fileReader;

    @BeforeEach
    void setUp() {
        fileReader = new InputOutputFileReader(
            "/platformexercises/hackerrank/threemonthpreparationkit/week3/Bsubarraydivision2/"
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
        String actual = SubArrayDivision2Solution.main(inputContent);

        // Then
        Assertions.assertEquals(expected.toString(), actual);
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return InputsOutputsTestCaseSource.inputsOutputsSource("", INPUTS_AND_OUTPUTS);
    }
}
