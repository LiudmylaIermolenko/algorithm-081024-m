package org.telran.lecture_04_d_and_c.practice.SumOfDigits;

// Задача:
// Дано целое положительное число.
// Найдите сумму его чисел

// Напишите рекурсивное решение

// Алгоритм
// Базовый случай:
// Если число n равно 0, функция возвращает 0. Это останавливает рекурсию.
// Рекурсивный случай:
// n % 10 извлекает последнюю цифру числа.
// n / 10 отбрасывает последнюю цифру.
// Функция рекурсивно вызывает саму себя с оставшимся числом и добавляет извлеченную цифру к результату рекурсивного вызова.


public class SumOfDigits {

    public static int sumOfDigitsRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigitsRecursive(n/10);
    }

    public static void main(String[] args) {
        int number = 12340;
        int result = sumOfDigitsRecursive(number);
        System.out.println("Сумма цифр числа " + number + " равна " + result);
    }
}