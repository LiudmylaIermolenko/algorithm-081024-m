package org.telran.lecture_8_st_and_qu.practice;

// В магазине продают только по три и по пять воздушных шариков.
// Можно ли купить ровно k шариков?

// Пример 1:
// Input: 8
// Output: Yes
// Пояснение: Можно купить 5 + 3 шарика

// Пример 2:
// Input: 10
// Output: Yes
// Пояснение: Можно купить 5 + 5 шариков

// Пример 3:
// Input: 7
// Output: No
// Пояснение: Никакими комбинациями 5 и 3, 7 шариков купить невозможно

public class Balloons {

    public static String canBuyBalloons(int k) {
        // Перебираем количество пятерок от 0 до k / 5
        for (int y = 0; y <= k / 5; y++) {
            // Проверяем, можно ли остаток после вычитания 5*y поделить на 3
            if ((k - 5 * y) % 3 == 0) {
                return "Yes";  // Нашли решение
            }
        }
        return "No";  // Не нашли решения
    }

    public static void main(String[] args) {
        System.out.println(canBuyBalloons(8)); // Yes
        System.out.println(canBuyBalloons(10)); // Yes
        System.out.println(canBuyBalloons(7)); // No
    }
}
