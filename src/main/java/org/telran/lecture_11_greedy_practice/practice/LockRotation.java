package org.telran.lecture_11_greedy_practice.practice;

public class LockRotation {
    public static int minRotations(String start, String target) {
        int rotations = 0;

        for (int i = 0; i < start.length(); i++) {
            int s = start.charAt(i) - '0';
            int t = target.charAt(i) - '0';
           // int s = Integer.parseInt(start.substring(i, i+1))

            int forward = Math.abs(s - t);
            int backward = 10 - forward;

            rotations += Math.min(forward, backward);
        }

        return rotations;
    }

    public static void main(String[] args) {
        String start = "2345";
        String target = "5432";

        int result = minRotations(start, target);
        System.out.println("Требуется оборотов = " + result);
    }
}
