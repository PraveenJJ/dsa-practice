> # Longest Common Prefix

## Problem Statement

Write a function to find the **longest common prefix string** amongst an array of strings.

If there is no common prefix, return an empty string `""`.

### Simple Explanation:
Find the **starting part of the string** that is common across **all strings** in the array.

---

## Examples

**Input 1:**
- `strs = ["flower","flow","flight"]`

**Output:** `"fl"`

---

**Input 2:**
- `strs = ["dog","racecar","car"]`

**Output:** `""`

---

**Input 3:**
- `strs = ["interview","internet","internal"]`

**Output:** `"inte"`

---

> ## 1. Naive Solution (Character-by-Character Comparison)

### Approach:
- Take the first string as a reference
- Compare its characters one by one with the same index in all other strings
- Stop when:
  - Any string ends, or
  - A mismatch is found
- Return the prefix formed so far

### Code for Naive Solution

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String first = strs[0];

            for (int i = 0; i < first.length(); i++) {
                char c = first.charAt(i);

                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return first.substring(0, i);
                    }
                }
            }

            return first;
        }
    }

### Time complexity - O(n * m)
- `n` = number of strings  
- `m` = length of the shortest string  
- Each character is compared across all strings

### Space complexity - O(1)
- No extra data structures are used

---

> ## 2. Optimized Solution (Prefix Shrinking)

### Key Insight
- The longest common prefix can only **shrink**, never grow
- Start with the first string as the prefix
- Keep reducing the prefix until it matches all strings

---

### Approach:
- Initialize prefix as the first string
- For each remaining string:
  - While the current string does not start with the prefix:
    - Remove the last character from the prefix
  - If prefix becomes empty, return `""`
- Return the final prefix

In short -> shrink it, check again, if contains prefix, then move to next string. Repeat the process.

---

### Code for Optimized Solution

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++) {
                while (!strs[i].startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);

                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }

            return prefix;
        }
    }

---

### Time complexity - O(n * m)
- In the worst case, prefix comparison happens for each string

### Space complexity - O(1)
- Prefix is reduced in place

---

### Interview One-Liner
- I take the first string as a reference prefix and keep shrinking it until it matches all other strings.  
- This ensures we find the longest common prefix efficiently without extra space.
- Both approaches run in O(n * m) time and O(1) space.
The prefix-shrinking approach is preferred for early termination.
---