package com.shouvit.assignments.assignment5;

public class Main {
    public static int fibonacci(int index) {
        if(index < 2) return index;
        int a = 0, b = 1;
        index -= 2;
        while(index >= 0) {
            int c = a + b;
            a = b;
            b = c;
            if(index-- == 0) break;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}
