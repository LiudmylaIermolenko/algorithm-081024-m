package org.telran.lecture_11_greedy_practice.practice.gifts;

// У вас есть список людей, которым нужно подарить подарки.
// У каждого человека есть предпочтения по подаркам, выраженные в виде списка желаемых подарков.
// Каждый подарок можно подарить только одному человеку. Ваша задача - осчастливить как можно больше людей.
//Идём по каждому человеку.
//
//Проверяем его список желаний.
//
//Если подарок ещё не занят, дарим его человеку.
//
//Продолжаем, пока не закончатся люди или подарки.

import java.util.*;

public class Gifts {
    public static void main(String[] args) {
        Map<String, List<String>> peoplePreferences = new HashMap<>();
        peoplePreferences.put("Alice", Arrays.asList("Book", "Game", "Pen"));
        peoplePreferences.put("Bob", Arrays.asList("Game", "Bicycle"));
        peoplePreferences.put("Charlie", Arrays.asList("Book", "Pen"));
        peoplePreferences.put("Diana", Arrays.asList("Bicycle"));

        Map<String, String> assignedGifts = assignGifts(peoplePreferences);

        System.out.println("Распределение подарков:");
        for (Map.Entry<String, String> entry : assignedGifts.entrySet()) {
            System.out.println(entry.getKey() + " получает " + entry.getValue());
        }
    }

    public static Map<String, String> assignGifts(Map<String, List<String>> preferences) {
        Map<String, String> result = new HashMap<>();
        Set<String> usedGifts = new HashSet<>();

        for (Map.Entry<String, List<String>> personEntry : preferences.entrySet()) {
            String person = personEntry.getKey();
            List<String> wishes = personEntry.getValue();

            for (String gift : wishes) {
                if (!usedGifts.contains(gift)) {
                    result.put(person, gift);
                    usedGifts.add(gift);
                    break; // Подарок назначен, переходим к следующему человеку
                }
            }
        }
        return result;

    }
}
