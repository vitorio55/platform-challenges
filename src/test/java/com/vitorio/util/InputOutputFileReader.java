package com.vitorio.util;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputOutputFileReader {

    private final String basePath;

    public InputOutputFileReader(String basePath) {
        this.basePath = basePath;
    }

    public File fileFromFilePath(String filePath) {
        URL fileUrl = this.getClass().getResource(basePath + filePath);
        return new File(fileUrl.getFile());
    }

    public String[] readFileContent(String filePath) throws IOException {
        URL fileUrl = this.getClass().getResource(basePath + filePath);
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
