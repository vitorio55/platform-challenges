package com.vitorio.platformexercises.hackerrank.threemonthpreparationkit.week3.Dsalesbymatch;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SalesByMatchSolution {

    // ----------------- TODO TAGS:
    //   #count of matching pairs

    public static String main(File input) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
            return String.valueOf(Result.sockMerchant(n, ar));
        }
    }

    static class Result {

        /*
         * Complete the 'sockMerchant' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY ar
         */

        public static int sockMerchant(int n, List<Integer> ar) {
            Map<Integer, Integer> socks = new HashMap<>();
            int pairsNum = 0;

            for (Integer sock : ar) {
                socks.put(sock, socks.getOrDefault(sock, 0) + 1);
                pairsNum += socks.getOrDefault(sock, 0) % 2 == 0 ? 1 : 0;
            }

            return pairsNum;
        }
    }
}
