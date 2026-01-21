# Maximum Subarray (Kadane’s Algorithm)

---

## Problem Statement

Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) which has the **largest sum**, and return its sum.

### Simple Explanation:
Find a continuous part of the array whose elements add up to the **maximum possible sum**.

---

## Examples

**Input 1:**
- `nums = [-2,1,-3,4,-1,2,1,-5,4]`

**Output:** `6`  
**Explanation:** The subarray `[4,-1,2,1]` has the largest sum.

---

**Input 2:**
- `nums = [1]`

**Output:** `1`

---

**Input 3:**
- `nums = [5,4,-1,7,8]`

**Output:** `23`

---

## 1. Naive Solution

### Approach:
- Consider every possible subarray
- Calculate the sum of each subarray
- Keep track of the maximum sum found

### Code for Naive Solution

    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int currentSum = 0;

                for (int j = i; j < nums.length; j++) {
                    currentSum = currentSum + nums[j]; 
                    maxSum = Math.max(maxSum, currentSum);
                }
            }

            return maxSum;
        }
    }

### Time complexity - O(n²)
- Two nested loops generate all possible subarrays

### Space complexity - O(1)
- No extra data structures are used

---

## 2. Optimized Solution (Kadane’s Algorithm)

### Key Insight
- At every index, decide whether to:
    - **Extend the previous subarray**, or
    - **Start a new subarray from the current element**
- If the previous sum becomes negative, it will only reduce future sums, so we discard it

### Approach:
- Initialize:
    - `currentSum` as the first element
    - `maxSum` as the first element
- Traverse the array from the second element onward
- For each element:
    - Update `currentSum` as:
      ```
      max(current element, currentSum + current element)
      ```
    - Update `maxSum` if `currentSum` is greater
- Return `maxSum`

### Code for Optimized Solution

    class Solution {
        public int maxSubArray(int[] nums) {
            int currentSum = nums[0];
            int maxSum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                currentSum = Math.max(nums[i], currentSum + nums[i]); //this line changes in naive solution 
                maxSum = Math.max(maxSum, currentSum);
            }

            return maxSum;
        }
    }

### Time complexity - O(n)
- The array is traversed once

### Space complexity - O(1)
- Only constant extra variables are used

---

### Interview One-Liner
- At each index, I decide whether to start a new subarray or extend the existing one.  
- By discarding negative sums early, Kadane’s Algorithm finds the maximum subarray sum in O(n) time.

---
