package org.telran.lecture_10_greedy_algo.hw;

// Дано:
//  Список активностей, каждая из которых характеризуется четырьмя параметрами:
//      Название (строка, уникальное имя активности)
//      Время начала (целое число, например, час начала активности)
//      Время окончания (целое число, например, час окончания активности)
//      Цена (целое число, положительное значение)
//Найти:
// Максимальный по суммарной стоимости набор, непересекающихся по времени активностей.
// Условия:
//  Активности считаются непересекающимися, если время окончания одной активности меньше или равно времени начала другой активности.
//  Необходимо использовать жадный алгоритм.


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Activity {
    private String name;
    private int start;
    private int end;
    private int cost;

    public Activity(String name, int start, int end, int cost) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }
    public static List<Activity> selectActivities(List<Activity> activities) {
        // Сортируем активности по времени окончания
        Collections.sort(activities, Comparator.comparingInt(Activity::getEnd));

        List<Activity> selectedActivities = new ArrayList<>();
        int lastEndTime = -1;

        for (Activity activity : activities) {
            if (activity.getStart() >= lastEndTime) {
                selectedActivities.add(activity);
                lastEndTime = activity.getEnd();
            }
        }

        return selectedActivities;
    }
    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A", 1, 3, 50));
        activities.add(new Activity("B", 3, 5, 60));
        activities.add(new Activity("C", 0, 6, 70));
        activities.add(new Activity("D", 5, 7, 80));
        activities.add(new Activity("E", 3, 9, 90));
        activities.add(new Activity("F", 5, 9, 100));

        List<Activity> selectedActivities = selectActivities(activities);

        System.out.println("Выбранные активности:");
        int totalCost = 0;
        for (Activity activity : selectedActivities) {
            System.out.println(activity.getName() + ": " + activity.getStart() + " - " + activity.getEnd() + ", Стоимость: " + activity.getCost());
            totalCost += activity.getCost();
        }
        System.out.println("Суммарная стоимость выбранных активностей: " + totalCost);
    }
}
