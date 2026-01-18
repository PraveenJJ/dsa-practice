package com.praveen.dsa.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Logic: Sliding window
 * #########################
 * --> when duplicates are found we remove from left
 * --> else we keep moving to the right
 * #########################
 * --> if set contains current character, remove character at left, increment left
 * --> after that, add current character to set, update maxLength = (right - left + 1)
 * --> continue for right 0 to n-1
 * --> return maxLength at the end
 * #########################
 * Time complexity = O(n) -- though while loop is nested, it won't restart for each iteration of for loop, it will just continue to n, so TC is just O(n) and not O(n^2)
 * Space complexity = O(n) -- set will store n elements
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = findLongestSubstring(s);
        System.out.println("Longest substring for \"" + s + "\" is of length " + result);
    }

    private static int findLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            while (set.contains(currentCharacter)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentCharacter);
            maxLength = Math.max(maxLength, (right - left + 1));
        }
        return maxLength;
    }


}
