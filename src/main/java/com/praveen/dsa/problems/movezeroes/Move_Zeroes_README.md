> # Move Zeroes

## Problem Statement

Given an integer array `nums`, move all `0`s to the **end of the array** while maintaining the **relative order of the non-zero elements**.

You must do this **in-place** without making a copy of the array.

### Simple Explanation:
Push all zero values to the end of the array, but **do not change the order** of the other numbers.

---

## Examples

**Input 1:**
- `nums = [0,1,0,3,12]`

**Output:** `[1,3,12,0,0]`

---

**Input 2:**
- `nums = [0]`

**Output:** `[0]`

---

> ## 1. Naive Solution

### Approach:
- Create a new array
- First copy all non-zero elements
- Remaining positions are by default filled with `0`
- Copy the result back to the original array

⚠️ This violates the **in-place** constraint but helps understand the logic.

### Code for Naive Solution

    class Solution {
        public void moveZeroes(int[] nums) {
            int[] temp = new int[nums.length];
            int index = 0;

            for (int num : nums) {
                if (num != 0) {
                    temp[index++] = num;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }

### Time complexity - O(n)
- Array is traversed once

### Space complexity - O(n)
- Extra array is used

---

> ## 2. Optimized Solution (Two Pointers – In-Place)

### Key Insight
- We only care about **non-zero elements**
- Place each non-zero element at the next available position
- Fill remaining positions with `0`
- This preserves order and works in-place

In short, instead of creating a new array, update existing array by moving non-zero elements forward. And then manually fill remaining positions with zeroes.

### Approach:
- Maintain a pointer `index` for the position of the next non-zero element
- Traverse the array from left to right
- When a non-zero element is found:
  - Place it at `nums[index]`
  - Increment `index`
- After traversal, fill remaining positions with `0`

### Code for Optimized Solution

    class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;

            // Move non-zero elements forward
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i]; //naive solution uses new array here
                    index++;
                }
            }

            // Fill remaining positions with zero
            while (index < nums.length) {
                nums[index] = 0;
                index++;
            }
        }
    }

### Time complexity - O(n)
- Single traversal of the array

### Space complexity - O(1)
- No extra data structures used

---

### Interview One-Liner
- I use a two-pointer approach, one to read every element & another to track non-zero elements.
- I then move all non-zero elements forward while maintaining their order. 
- Later fill the remaining positions with zeros.

---