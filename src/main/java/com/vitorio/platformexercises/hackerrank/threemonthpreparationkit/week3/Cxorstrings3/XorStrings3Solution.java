package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Cxorstrings3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////////////////////////
// This exercise is broken in Hackerrank as of jan 2024 and won't accept answers !!
// Select Java7 and use that code
// Below the method baseStringsXORToChange() can be found as it is given by the exercise
///////////////////////////////////////////////////////////////////////////////////////////////

public class XorStrings3Solution {

    public static String main(File input) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String s, t;
            s = bufferedReader.readLine();
            t = bufferedReader.readLine();
            sb.append(Result.stringsXOR(s, t));
        }
        return sb.toString();
    }

    class Result {

        public static String stringsXOR(String s, String t) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i))
                    res.append("0");
                else
                    res.append("1");
            }
            return res.toString().trim();
        }
    }
}
