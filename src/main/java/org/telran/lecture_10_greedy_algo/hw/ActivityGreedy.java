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
import java.util.Comparator;
import java.util.List;

//Будем выбирать самую выгодную активность среди доступных, которая не пересекается с
// уже выбранными. будем сортировать активности по цене за единицу времени — cost / (end - start).)
public class ActivityGreedy {

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity("Drawing", 1, 4, 10));
        activities.add(new Activity("Writing", 3, 5, 20));
        activities.add(new Activity("Coding", 0, 6, 70));
        activities.add(new Activity("Reading", 5, 7, 30));
        activities.add(new Activity("Dancing", 8, 9, 50));
        activities.add(new Activity("Running", 5, 9, 40));

        print(activities);
        System.out.println("------");

        List<Activity> selected = selectActivities(activities);
        System.out.println("Выбранные активности:");
        for (Activity activity : selected) {
            System.out.println(activity);
        }
//        List<Activity> selectedCost = selectMaxCostActivities(activities);
//
//        System.out.println("Обрані активності з максимальною вартістю:");
//        for (Activity activity : selectedCost) {
//            System.out.println(activity);
//        }
    }
    public static List<Activity> selectActivities(List<Activity> activities){
//        activities.sort(
//                Comparator.comparingInt(a -> a.end)
//                        .thenComparing((a1, a2) -> Integer.compare(a2.cost, a1.cost))
//        );
        // Сортируем по окончанию активности (если равные — по большей стоимости)
        activities.sort(Comparator.comparingInt(Activity::getEnd).thenComparing((a1, a2) -> Integer.compare(a2.getCost(), a1.getCost())));
//Что здесь происходит:
//Activity::getEnd — сначала сортируем по времени окончания end (по возрастанию).
//thenComparing(Comparator.comparingInt(Activity::getCost).reversed()) — потом, если времена окончания одинаковые,
// сортируем по стоимости cost (но в обратном порядке — сначала дороже).
        List<Activity> selected = new ArrayList<>();
        int currentEnd = -1;
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).start >= currentEnd) {
                currentEnd = activities.get(i).end;
                selected.add(activities.get(i));
            }
        }
        return selected;
    }
    public static void print(List<Activity> activities) {
        for (Activity e : activities) {
            System.out.println(e);
        }
    }

    public static class Activity {
        private String name;
        private int start;
        public int end;
        public int cost;

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

        @Override
        public String toString() {
            return name + " " + start + "-" + end + ", cost: " + cost;
        }
    }
}








