package org.telran.lecture_11_greedy_practice.practice.backpack;

// Есть набор предметов, у каждого предмета есть: цена и вес.
// Требуется выбрать из заданного набора предметов наиболее ценные, которые поместятся в рюкзак заданной вместимости.

// Алгоритм
// 1. Рассчитываем удельную ценность для каждого предмета.
// 2. Сортируем предметы по убыванию удельной ценности.
// 3. Складываем предметы в рюкзак(массив), по суммарный вес не превысит максимально допустимый

import java.util.Arrays;

public class Backpack {
    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item("A", 4, 8),
                new Item("B", 5, 9),
                new Item("C", 6, 10),
                new Item("D1", 3, 5),
                new Item("D2", 2, 3),
        };

        int maxWeight = 10;

        Arrays.sort(items, (a, b) -> Double.compare(
                b.getValuePerWeight(), a.getValuePerWeight()));

        int totalWeight = 0;
        int totalValue = 0;

        System.out.println("Выбранные предметы:");
        for (Item item : items) {
            if (totalWeight + item.weight <= maxWeight) {
                totalWeight += item.weight;
                totalValue += item.value;
                System.out.println("- " + item.name + " (вес: " + item.weight + ", ценность: " + item.value + ")");
            }
        }

        System.out.println("Общий вес: " + totalWeight);
        System.out.println("Общая ценность: " + totalValue);
    }
}


