package org.telran.lecture_10_greedy_algo.practice.coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Напишите программу, используя жадный алгоритм.
// Задача:
// Монетная система некоторого государства состоит из монет достоинством: 1, 2, 5, 10
// Требуется выдать сумму x, наименьшим возможным количеством монет.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfCoin {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int sum = 100;
        System.out.println(getChange(sum, coins));
    }

    private static List<Integer> getChange(int sum, int[] coins) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
         while (sum >= coins[i]) {
             sum -= coins[i];
             result.add(coins[i]);
         }
        }
       return result;
    }
}
