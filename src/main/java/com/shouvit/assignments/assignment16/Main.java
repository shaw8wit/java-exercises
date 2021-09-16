package com.shouvit.assignments.assignment16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String integer = "", nonint = "";
        int count = 0, inte = 0, sum = 0;
        while(true) {
            if(s.hasNextInt()) {
                int temp = s.nextInt();
                integer += temp + ", ";
                sum += temp;
                inte++;
            } else {
                String non = s.nextLine();
                nonint += non;
                if(non.contains("NO")) break;
            }
            count++;
        }
        System.out.println("Number of inputs = " + count +
                "\nNumber of integer inputs = " + inte +
                "\nNumber of non-integer inputs = " + (count - inte) +
                "\nSum of all integer inputs = " + sum +
                "\nThe integer inputs = " + integer +
                "\nThe non-integer inputs = " + nonint);
    }
}
