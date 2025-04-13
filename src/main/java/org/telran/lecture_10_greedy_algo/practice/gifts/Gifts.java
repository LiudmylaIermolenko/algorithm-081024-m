package org.telran.lecture_10_greedy_algo.practice.gifts;

// У вас есть список людей, которым нужно подарить подарки и список подарков.
// У каждого человека есть предпочтения по подаркам, выраженные в виде списка желаемых подарков.
// Каждый подарок можно подарить только одному человеку. Ваша задача - осчастливить как можно больше людей.


import java.util.*;

public class Gifts {
    public static void main(String[] args) {
 //Список людей с их предпочтениями
        List<Person> people = Arrays.asList(
                new Person("Alice", Arrays.asList(0, 2)),
                new Person("Bob", Arrays.asList(1, 0)),
                new Person("Charlie", Arrays.asList(2, 1))
        );

        // Список подарков
        List<String> gifts = Arrays.asList("Book", "Laptop", "Phone");

        List<String> result = assignGifts(people, gifts);

        // Выводим, кто какой подарок получил
        for (int i = 0; i < result.size(); i++) {
            System.out.println(people.get(i).name + " -> " + result.get(i));
        }
    }

    private static List<String> assignGifts(List<Person> people, List<String> gifts) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            result.add(null);
        }
        // Отмечаем, какие подарки уже заняты
        boolean[] used = new boolean[gifts.size()];

        // Проходим по каждому человеку
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            for (int giftIndex : person.preferences) {
                if (!used[giftIndex]) {
                    used[giftIndex] = true; // помечаем подарок как занятый
                    result.set(i, gifts.get(giftIndex)); // записываем, кто что получил
                    break; // переходим к следующему человеку
                }
            }
        }
        return result;
    }

    static class Person {
        String name;
        List<Integer> preferences;

        Person(String name, List<Integer> preferences) {
            this.name = name;
            this.preferences = preferences;
        }
    }

}
//// Люди и их предпочтения
//        Map<String, List<String>> preferences = new HashMap<>();
//        preferences.put("Alice", Arrays.asList("Book", "Pen"));
//        preferences.put("Bob", Arrays.asList("Pen", "Game"));
//        preferences.put("Charlie", Arrays.asList("Book", "Game1"));
//        preferences.put("Diana", Arrays.asList("Game"));
//
//        // Все доступные подарки
//        Set<String> availableGifts = new HashSet<>(Arrays.asList("Book", "Pen", "Game", "Game1"));
//
//        // Результат: кто что получит
//        Map<String, String> assignedGifts = new HashMap<>();
//        Set<String> usedGifts = new HashSet<>();
//
//        // Проходим по людям
//        for (Map.Entry<String, List<String>> entry : preferences.entrySet()) {
//            String person = entry.getKey();
//            List<String> wants = entry.getValue();
//            boolean giftAssigned = false;  // Переменная для отслеживания, получил ли человек подарок
//
//            for (String gift : wants) {
//                if (availableGifts.contains(gift) && !usedGifts.contains(gift)) {
//                    assignedGifts.put(person, gift);
//                    usedGifts.add(gift);
//                    giftAssigned = true;
//                    break;  // Подарок найден — переходим к следующему человеку
//                }
//            }
//            // Если подарок не был назначен, записываем, что человек не получил подарок
//            if (!giftAssigned) {
//                assignedGifts.put(person, "No gift");  // Можно использовать строку "No gift" или null
//            }
//        }
//
//        // Вывод результата
//        for (Map.Entry<String, String> entry : assignedGifts.entrySet()) {
//            System.out.println(entry.getKey() + " получит " + entry.getValue());
//        }
//    }
//}