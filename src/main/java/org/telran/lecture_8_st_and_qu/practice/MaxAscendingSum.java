package org.telran.lecture_8_st_and_qu.practice;

// Дан массив положительных целых чисел.
// Найти максимально возможную сумму возрастающего подмассива.
// Подмассив определяется как непрерывная последовательность чисел в массиве.

// Пример 1:
//
// Input: nums = [10,20,30,5,10,50]
// Output: 65
// Пояснение: [5,10,50] — возрастающий подмассив с максимальной суммой 65.

// Пример 2:
//
// Input: nums = [10,20,30,40,50]
// Output: 150
// Пояснение: [10,20,30,40,50] — возрастающий подмассив с максимальной суммой 65.

public class MaxAscendingSum {
    public static void main(String[] args) {

        int[] nums1 = {10, 20, 30, 5, 10, 50};
        int[] nums2 = {10, 20, 30, 40, 50};

        System.out.println("Максимальная сумма возрастающего подмассива для массива 1: " + maxAscendingSum(nums1));
        System.out.println("Максимальная сумма возрастающего подмассива для массива 2: " + maxAscendingSum(nums2));
    }

    // Метод для нахождения максимальной суммы возрастающего подмассива
    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0; // Максимальная сумма
        int currentSum = 0; // Текущая сумма

        // Проходим по массиву
        for (int i = 0; i < nums.length; i++) {
            // Если текущее число больше предыдущего, увеличиваем текущую сумму
            if (i == 0 || nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                // Если текущее число не больше предыдущего, обновляем maxSum и сбрасываем currentSum
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i];
            }
        }

        // В конце проверим еще раз, чтобы учесть последний подмассив
        return Math.max(maxSum, currentSum);
    }
}
