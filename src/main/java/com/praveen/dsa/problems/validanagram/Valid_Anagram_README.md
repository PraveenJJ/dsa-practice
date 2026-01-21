# Valid Anagram

---

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an **anagram** of `s`, and return `false` otherwise.

An **anagram** is formed by rearranging the letters of a string using **all the original letters exactly once**.

### Simple Explanation:
Check whether both strings contain the **same characters, same number of times**, regardless of order.

---

## Examples

**Input 1:**
- `s = "anagram"`
- `t = "nagaram"`

**Output:** `true`

---

**Input 2:**
- `s = "rat"`
- `t = "car"`

**Output:** `false`

---

## 1. Naive Solution (Sorting)

### Approach:
- Convert both strings into character arrays
- Sort both arrays
- Compare them character by character
- If they are equal, the strings are anagrams

### Code for Naive Solution

    import java.util.Arrays;

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            Arrays.sort(sArr);
            Arrays.sort(tArr);

            return Arrays.equals(sArr, tArr);
        }
    }

### Time complexity - O(n log n)
- Sorting both strings dominates the runtime

### Space complexity - O(n)
- Extra space is used for character arrays

---

## 2. Naive Solution (HashMap – Without Sorting)

### Approach:
- If the lengths of the strings are different, return `false`
- Use a HashMap to count character frequencies in the first string
- Traverse the second string and reduce the frequency
- If a character is missing or frequency becomes invalid, return `false`
- If all frequencies balance out, the strings are anagrams

### Code for Naive Solution (HashMap)

    import java.util.HashMap;
    import java.util.Map;

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> map = new HashMap<>();

            // Count characters in s
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Reduce counts using t
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)) {
                    return false;
                }

                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }

            return map.isEmpty();
        }
    }

### Time complexity - O(n)
- Each string is traversed once

### Space complexity - O(n)
- HashMap stores character frequencies

---

## 3. Optimized Solution (Frequency Array)

### Key Insight
- Anagrams depend on **character frequency**, not order
- If both strings contain the same characters the same number of times, they are anagrams
- Since the input contains only lowercase English letters, we can use a **fixed-size frequency array**

### Approach:
- If the lengths of the strings are different, return `false`
- Create an integer array of size `26` to store character counts
- Traverse both strings at the same time:
  - Increment the count for characters in `s`
  - Decrement the count for characters in `t`
- If all values in the frequency array are `0`, the strings are anagrams

### Code for Optimized Solution

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] freq = new int[26];

            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++; // increment
                freq[t.charAt(i) - 'a']--; // decrement
            }

            for (int count : freq) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }

### Time complexity - O(n)
- Each string is traversed once

### Space complexity - O(1)
- Fixed-size array of 26 elements

---

### Interview One-Liner
- I count character frequencies using a fixed-size array.  
- By incrementing counts for one string and decrementing for the other, I can verify anagrams in O(n) time.

---