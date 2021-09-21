package com.shouvit.assignments.assignment10;

public class Main {
    public static String reverseByWords(String sentence) {
        StringBuilder ans = new StringBuilder();
        String temp = "";
        for(int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c == ' ') {
                ans.insert(0, temp + c);
                temp = "";
            } else {
                temp += c;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String out = reverseByWords("my name is vinod and i live in bangalore ");
        System.out.println(out);
    }
}
