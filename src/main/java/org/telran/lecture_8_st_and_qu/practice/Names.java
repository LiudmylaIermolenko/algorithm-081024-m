package org.telran.lecture_8_st_and_qu.practice;

// Дан массив имен.
// Найдите самое длинное имя, если таких имен несколько - выведи любое их них

public class Names {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlotte", "Michael", "Elizabeth"};

        String longestName = findLongestName(names);
        System.out.println("LongestName is " + longestName);

    }
    public static String findLongestName(String[] names){
        String longest = names[0];
        for (String name : names){
            if (name.length() > longest.length()){
                longest = name;
            }
        }
        return longest;
    }
}
