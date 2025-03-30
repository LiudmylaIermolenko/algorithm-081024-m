package org.telran.lecture_8_st_and_qu.practice;

// Даны две строки.
// Проверить, являются ли они анаграммами (состоят из одних и тех же букв, но в разном порядке).

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        // Пример строк для проверки
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println("Строки являются анаграммами.");
        } else {
            System.out.println("Строки не являются анаграммами.");
        }
    }

    // Метод для проверки анаграмм
    public static boolean areAnagrams(String str1, String str2) {
        // Если длина строк разная, они не могут быть анаграммами
        if (str1.length() != str2.length()) {
            return false;
        }

        // Преобразуем строки в массивы символов
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Сортируем массивы
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Сравниваем отсортированные массивы
        return Arrays.equals(arr1, arr2);
    }
}
