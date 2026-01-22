> # Contains Duplicate

## Problem Statement

Given an integer array `nums`, return `true` if **any value appears at least twice** in the array, and return `false` if **every element is distinct**.

### Simple Explanation:
Check whether the array contains **any duplicate number**.

---

## Examples

**Input 1:**
- `nums = [1,2,3,1]`

**Output:** `true`

**Input 2:**
- `nums = [1,2,3,4]`

**Output:** `false`

**Input 3:**
- `nums = [1,1,1,3,3,4,3,2,4,2]`

**Output:** `true`

---

> ## 1. Naive Solution

### Approach:
- Pick one number
- Compare it with every number that comes after it
- If any two numbers are equal, return `true`
- If no duplicates are found, return `false`

### Code for Naive Solution

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

### Time complexity - O(n²)
- We compare every pair of elements using two nested loops

### Space complexity - O(1)
- No extra data structures are used

---

> ## 2. Optimized Solution

### Key Insight
- A `Set` does not allow duplicate values
- While iterating, if an element already exists in the set, it means we found a duplicate
- This allows us to stop early and avoid unnecessary comparisons

### Approach:
- Create an empty HashSet 
- Traverse the array once 
- For each number:
  - Try to add the number to the set 
  - If add() returns false, the element already exists → return true 
- If the loop finishes without finding duplicates, return false

### Code for Optimized Solution

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (!set.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }

### Time complexity - O(n)
- We traverse the array only once

### Space complexity - O(n)
- In the worst case, all elements are stored in the HashSet

---

### Interview One-Liner
- I use a HashSet and rely on its add() method, which returns false when an element already exists.
- This allows me to detect duplicates in a single pass with O(n) time complexity.

---
