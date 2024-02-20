package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Ecamelcase4;

import java.io.IOException;
import java.util.Arrays;

public class CamelCase4Solution {

    public static String main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(args).forEach(l -> {
            if (l.charAt(0) == 'S') {
                sb.append(splitOperation(l));
            } else {
                sb.append(concatOperation(l));
            }
        });
        return sb.toString();
    }

    private static String concatOperation(String s) {
        String[] split = s.split(";");
        String type = split[1];
        String name = split[2];

        StringBuilder composed = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            if (i == 0 && type.equals("C")) {
                composed.append(Character.toUpperCase(name.charAt(i)));
                continue;
            }
            if (name.charAt(i) == ' ') {
                composed.append(Character.toUpperCase(name.charAt(i + 1)));
                i++;
            } else {
                composed.append(name.charAt(i));
            }
        }
        if (type.equals("M")) {
            composed.append("()");
        }
        return composed.toString();
    }

    private static String splitOperation(String s) {
        String[] split = s.split(";");
        String type = split[1];
        String name = split[2];

        StringBuilder composed = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            if (i == 0 && type.equals("C")) {
                composed.append(Character.toLowerCase(name.charAt(i)));
                continue;
            }
            if (Character.isUpperCase(name.charAt(i))) {
                composed.append(" ");
                composed.append(Character.toLowerCase(name.charAt(i)));
            } else {
                composed.append(name.charAt(i));
            }
            if (type.equals("M") && i > name.length() - 4) {
                break;
            }
        }
        return composed.toString();
    }
}
