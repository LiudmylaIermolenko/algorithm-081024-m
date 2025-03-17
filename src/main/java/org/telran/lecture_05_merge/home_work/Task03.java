package org.telran.lecture_05_merge.home_work;

// "Рекламная акция"
// В сети магазинов "Н-Аудио" проводится рекламная акция. Каждый второй товар – бесплатно.
// Естественно, кассирам дано указание пробивать товары в таком порядке, чтобы магазин
// потерял как можно меньше денег.
// По списку товаров определите максимальную сумму в чеке.
//
// Вход: дан массив натуральных чисел – цены товаров.
// Выход: одно число – максимальная сумма чека.

// Пример
// Вход:
    // 2 1 10 50 10
// Выход:
    // 70
// Пояснение:
    // Возможен такой порядок: 10 2 50 1 10

import java.util.Arrays;

import java.util.Arrays;

import static org.telran.lecture_05_merge.practice.MergeSort.mergeSort;

public class Task03 {
    public static void main(String[] args) {
<<<<<<< HEAD
        int[] prices = {10, 2, 50, 1, 10, 30, 7};
        int[] sortedPrices = mergeSort(prices);
        System.out.println(Arrays.toString(sortedPrices));

        int middle = sortedPrices.length / 2;
        int sum = 0;
        for (int i = middle; i < sortedPrices.length; i++) {
        sum += sortedPrices[i];
        }
        //Arrays.copyOfRange(originalArray, from, to);
        int[] expensiveItems = Arrays.copyOfRange(sortedPrices, middle, sortedPrices.length);
        System.out.println(Arrays.toString(expensiveItems));

//        int sum = 0;
//        for (int price : expensiveItems) {
//            sum += price;
//        }

        System.out.println("Максимальная сумма чека: " + sum);
=======
        int[] prices = {2, 1, 10, 50, 10, 22, 2}; // Цены товаров которые вы купили
        System.out.println(getMaxDiscountedTotal(prices));
    }

    public static int getMaxDiscountedTotal(int[] prices) {
        Arrays.sort(prices);
        int sum = 0;
        for (int i = prices.length / 2; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum;
>>>>>>> origin/main
    }
}
//  // Рекурсивно вызываем mergeSort() для левой и правой частей.
//Объединяем отсортированные части в один массив с помощью merge().
//    public static int[] mergeSort(int[] array) {
//        if (array.length <= 1) {
//            return array;
//        }
//
//        int middle = array.length / 2;
//        int[] left = Arrays.copyOfRange(array, 0, middle);
//        int[] right = Arrays.copyOfRange(array, middle, array.length);
//
//        return merge(mergeSort(left), mergeSort(right));
//    }
//
//    public static int[] merge(int[] left, int[] right) {
//        int[] result = new int[left.length + right.length];
//        int i = 0, j = 0, k = 0;
//
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j]) {
//                result[k++] = left[i++];
//            } else {
//                result[k++] = right[j++];
//            }
//        }
//
//        while (i < left.length) {
//            result[k++] = left[i++];
//        }
//
//        while (j < right.length) {
//            result[k++] = right[j++];
//        }
//
//        return result;
//    }
//}


