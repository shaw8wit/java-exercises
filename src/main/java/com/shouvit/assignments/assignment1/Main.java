package com.shouvit.assignments.assignment1;

public class Main {
    static boolean isValidDate(int year, int month, int day) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year >= 0 && month >= 1 && month <= 12) {
            if (month == 2 && (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))) {
                arr[1] += 1;
            }
            return day > 1 && day <= arr[month - 1];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidDate(2100, 02, 28));
    }
}
