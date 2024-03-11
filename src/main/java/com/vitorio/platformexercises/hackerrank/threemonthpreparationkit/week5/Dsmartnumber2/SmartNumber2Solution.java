package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week5.Dsmartnumber2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SmartNumber2Solution {

    public static String main(File input) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int test_cases = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < test_cases; i++) {
                int num = Integer.parseInt(bufferedReader.readLine());
                boolean ans = isSmartNumber(num);
                if (ans){
                    sb.append("YES");
                }
                else sb.append("NO");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);
        //if(num / val == 1)
        if((val * val) / num == 1)
            return true;
        return false;
    }
}
