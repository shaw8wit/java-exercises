package com.shouvit.assignments.assignment3;

import java.util.Arrays;

public class Main {
    public static void sortThreeNumbers(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        sortThreeNumbers(10, 34, 7);
    }
}
