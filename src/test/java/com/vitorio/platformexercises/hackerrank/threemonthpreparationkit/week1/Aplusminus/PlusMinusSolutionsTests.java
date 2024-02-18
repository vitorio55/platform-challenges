package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Aplusminus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PlusMinusSolutionsTests {

    private static final String BASE_PATH = "/platformexercises/hackerrank/threemonthpreparationkit/week1/Aplusminus/";

    @ParameterizedTest
    @MethodSource("inputsOutputsSource")
    void testSolution(String input, String output) throws IOException {
        String[] inputContent = readFileContent(input);
        String[] outputContent = readFileContent(output);
        StringBuilder expected = new StringBuilder();
        for (String s : outputContent) {
            expected.append(s).append("\n");
        }

        // When
        String result = PlusMinusSolution.main(inputContent);

        Assertions.assertEquals(expected.toString(), result);
    }

    private static Stream<Arguments> inputsOutputsSource() {
        return Stream.of(
            Arguments.of(BASE_PATH + "case0/input.txt", BASE_PATH + "case0/output.txt"),
            Arguments.of(BASE_PATH + "case1/input.txt", BASE_PATH + "case1/output.txt")
        );
    }

    private String[] readFileContent(String filePath) throws IOException {
        URL fileUrl = this.getClass().getResource(filePath);
        File file = new File(fileUrl.getFile());
        return getContent(file);
    }

    private String[] getContent(File file) throws IOException {
        Path filePath = Paths.get(file.getAbsolutePath());
        long linesInFile = Files.lines(filePath).count();
        String[] content = new String[(int) linesInFile];
        String line;
        int i = 0;
        try (BufferedReader br =
                 new BufferedReader(
                     new InputStreamReader(
                         new FileInputStream(file)))
        ) {
            while ((line = br.readLine()) != null) {
                content[i++] = (line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
