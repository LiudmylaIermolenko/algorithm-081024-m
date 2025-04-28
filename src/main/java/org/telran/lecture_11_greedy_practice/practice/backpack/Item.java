package org.telran.lecture_11_greedy_practice.practice.backpack;

public class Item {
    public String name;
    public int weight;
    public int value;
    public int unit_value; // Удельная ценность - цена за единицу веса

    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public double getValuePerWeight() {
        return (double) value / weight;
    }

}
