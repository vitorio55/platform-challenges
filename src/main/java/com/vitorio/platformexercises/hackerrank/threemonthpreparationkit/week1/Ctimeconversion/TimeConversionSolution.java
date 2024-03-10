package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week1.Ctimeconversion;

import java.io.IOException;

public class TimeConversionSolution {

    public static String main(String[] args) throws IOException {
        String s = args[0];
        return Result.timeConversion(s);
    }

    static class Result {

        /*
         * Complete the 'timeConversion' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */

        public static String timeConversion(String s) {
            boolean isAm = s.contains("AM");
            boolean isPm = !isAm;

            String[] split = s.split(":");
            split[2] = split[2].replace("AM", "");
            split[2] = split[2].replace("PM", "");

            int hours = Integer.parseInt(split[0]);
            int mins = Integer.parseInt(split[1]);
            int seconds = Integer.parseInt(split[2]);

            if (isAm && hours == 12) {
                hours = 0; // EX 12:04:23AM -> 00:04:23
            } else if (isPm && (1 < hours && hours < 12)) {
                hours += 12; // EX 04:25:19PM -> 16:25:19
            }

            String convertedHoursStr = hours < 10 ? ("0" + hours) : Integer.toString(hours);
            String convertedMinutesStr = mins < 10 ? ("0" + mins) : Integer.toString(mins);
            String convertedSecondsStr = seconds < 10 ? ("0" + seconds) : Integer.toString(seconds);

            return convertedHoursStr + ":" + convertedMinutesStr + ":" + convertedSecondsStr;
        }

    }
}
