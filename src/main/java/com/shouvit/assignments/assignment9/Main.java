package com.shouvit.assignments.assignment9;

public class Main {
    public static int[] sumOfEvensAndOdds(int []nums) {
        int [] ans = new int [2];
        for(int i : nums) {
            ans[i % 2] += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] result = sumOfEvensAndOdds(nums);
        System.out.println("{" + result[0] + ", " + result[1] + "}");
    }
}
