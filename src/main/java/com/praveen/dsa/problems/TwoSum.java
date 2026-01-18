package com.praveen.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Logic: HashMap + Complement
 * #########################
 * --> find complement of current number
 * --> lookup for complement in map
 * --> if not found, then add [current number(key), current index(value)] to map
 * --> if found, return [complement's value from map, current index]
 * #########################
 * Time complexity = O(n) -- one for loop iteration
 * Space complexity = O(n) -- map of size n
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);
        System.out.println("Two sum out for array " + Arrays.toString(nums) + " & target " + target + " is " + Arrays.toString(result));
    }

    private static int[] findTwoSum(int[] nums, int target) {
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
