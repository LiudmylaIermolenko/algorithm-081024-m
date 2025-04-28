package org.telran.lecture_11_greedy_practice.practice.hw;

// Задача: вызов лифта
// В доме n лифтов, у каждого лифта своя скорость, измеряемая в сек/этаж (секунд на один этаж).
// Реализовать алгоритм отправки лифта, который приедет быстрее всего.
// Алгоритм будет применяться в домах разной этажности.
// Алгоритм будет применяться в домах с количеством > 2 лифтов
// Пример:
//  в доме 19 этажей
//  работают лифт А, лифт В и лифт C
//  лифт А находится на 4 этаже и движется со скоростью 3 сек/этаж.
//  лифт В находится на 8 этаже и движется со скоростью 2 сек/этаж.
//  лифт C находится на 5 этаже и движется со скоростью 2 сек/этаж.
//  На вход: 1 (вызываем на первый этаж)
//  результат: отправляем лифт С


import java.util.ArrayList;
import java.util.List;

//Что нужно сделать?
//
//У нас есть несколько лифтов (каждый знает свой этаж и скорость).
//
//Приходит запрос на этаж (например, на 1 этаж).
//
//Нужно выбрать тот лифт, который доедет быстрее всех.
//
//Время приезда для лифта =
//|текущий этаж - вызываемый этаж| × скорость (секунд на этаж)
public class Lift {
    String name;
    int currentFloor;
    int secondsPerFloor;

    public Lift(String name, int currentFloor, int secondsPerFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
        this.secondsPerFloor = secondsPerFloor;
    }

    // Метод, чтобы рассчитать время до нужного этажа
    public int timeToFloor(int requestedFloor) {
        return Math.abs(currentFloor - requestedFloor) * secondsPerFloor;
    }

    @Override
    public String toString() {
        return "Лифт " + name + " (этаж: " + currentFloor + ", скорость: " + secondsPerFloor + " сек/этаж)";
    }

    public static void main(String[] args) {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(new Lift("A", 4, 3)); // Лифт A: на 4 этаже, 3 сек/этаж
        lifts.add(new Lift("B", 8, 2)); // Лифт B: на 8 этаже, 2 сек/этаж
        lifts.add(new Lift("C", 5, 2)); // Лифт C: на 5 этаже, 2 сек/этаж

        int requestedFloor = 1; // вызов на 1 этаж

        Lift bestLift = findBestLift(lifts, requestedFloor);

        System.out.println("Отправляем: " + bestLift);
    }

    public static Lift findBestLift(List<Lift> lifts, int requestedFloor) {
        Lift best = lifts.get(0);
        int minTime = best.timeToFloor(requestedFloor);

        for (Lift lift : lifts) {
            int time = lift.timeToFloor(requestedFloor);
            if (time < minTime) {
                minTime = time;
                best = lift;
            }
        }
        return best;
    }
}
