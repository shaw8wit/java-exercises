package com.shouvit.assignments.assignment2;

public class Main {
    public static boolean isPrimeNumber(int num) {
        if(num == 1) return false;
        for(int i = 2; i < num / 2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrimeNumber(59));
    }
}
