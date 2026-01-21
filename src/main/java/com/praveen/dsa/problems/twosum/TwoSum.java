package com.praveen.dsa.problems.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result1 = naiveSolution(nums, target);
        System.out.println("Two sum out for array " + Arrays.toString(nums) + " & target " + target + " is " + Arrays.toString(result1) + " (Naive Solution)");

        int[] result2 = optimizedSolution(nums, target);
        System.out.println("Two sum out for array " + Arrays.toString(nums) + " & target " + target + " is " + Arrays.toString(result2) + " (Optimized Solution)");
    }

    private static int[] naiveSolution(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    private static int[] optimizedSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

}
