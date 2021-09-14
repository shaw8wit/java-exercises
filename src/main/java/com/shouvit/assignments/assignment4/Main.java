package com.shouvit.assignments.assignment4;

import static com.shouvit.assignments.assignment2.Main.isPrimeNumber;

public class Main {
    public static int sumOfPrimes(int from, int to) {
        int sum = 0;
        while(from <= to) {
            if(isPrimeNumber(from)) {
                sum += from;
//                System.out.println(from)
            }
            from++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfPrimes(20, 200));
    }
}
