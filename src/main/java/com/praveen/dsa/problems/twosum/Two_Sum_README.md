> # Two Sum

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.

### Simple Explanation:
Find two different numbers in the list that add up to the target, and return their indexes.

---

## Examples

**Input 1:**
- `nums = [2,7,11,15]`
- `target = 9`

**Output:** `[0,1]`

**Input 2:**
- `nums = [3,2,4]`
- `target = 6`

**Output:** `[1,2]`

---

> ## 1. Naive Solution

### Approach:
- Pick one number
- Pair it with every number that comes after it
- Check if the pair adds up to the target 
- If it does, we return their positions.

### Code for Naive Solution
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return new int[] {};
        }
    }

### Time complexity - O(n²)
- We check all possible pairs using two nested loops

### Space complexity - O(1)
- No extra data structures are used

---
> ## 2. Optimized Solution

### Key Insight
- If nums[i] + nums[j] = target, then nums[j] = target - nums[i].  
- So for each number, we only need to check if its complement was seen earlier.
- This allows us to avoid checking all pairs and solve the problem in a single pass.
- Always check for complement before inserting the current number to avoid using the same element twice

### Approach:
- Start with an empty map 
- Go through the array once, from left to right 
- For the current number:
  - Calculate the complement
- Check if complement exists in the map
- If it exists:
  - We’ve found the answer → return complement's index & current index
- If it does not exist:
  - Store the current number and its index in the map
- Continue until the pair is found

### Code for Optimized Solution

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(); 
            // map stores: number -> index
            
            for (int i = 0; i < nums.length; i++) {
                // calculate complement
                int complement = target - nums[i];
    
                // check if complement exists in map
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
    
                // store current number with its index
                map.put(nums[i], i);
            }
            return new int[] {};
        }
    }


### Time complexity - O(n)
- We traverse the array once

### Space complexity - O(n)
- We store up to n elements in a HashMap

---

### Interview One-Liner
I use a HashMap to store previously seen numbers and their indices.  
For each element, I check if its complement exists, allowing me to solve the problem in O(n) time.

---