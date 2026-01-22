> # Valid Palindrome

## Problem Statement

Given a string `s`, determine if it is a **palindrome**, considering **only alphanumeric characters** and **ignoring cases**.

A palindrome is a string that reads the same forward and backward.

### Simple Explanation:
Ignore all special characters and spaces, and check whether the string reads the same from left to right and right to left.

---

## Examples

**Input 1:**
- `s = "A man, a plan, a canal: Panama"`

**Output:** `true`

---

**Input 2:**
- `s = "race a car"`

**Output:** `false`

---

**Input 3:**
- `s = " "`  

**Output:** `true`

---

## 1. Naive Solution (Clean, Reverse & Compare)

### Approach:
- Create a cleaned version of the string by:
  - Removing all non-alphanumeric characters
  - Converting all characters to lowercase
- Create a reversed version of the cleaned string
- Compare the cleaned string with its reversed version
- If both are equal, the string is a palindrome

### Code for Naive Solution

    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder cleaned = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    cleaned.append(Character.toLowerCase(c));
                }
            }

            String original = cleaned.toString();
            String reversed = cleaned.reverse().toString();

            return original.equals(reversed);
        }
    }

### Time complexity - O(n)
- Cleaning the string, reversing it, and comparing all take linear time

### Space complexity - O(n)
- Extra space is used to store the cleaned and reversed strings

---

> ## 2. Optimized Solution (Two Pointers – In-Place)

### Key Insight
- We do not need to create a new string
- Use two pointers:
  - One from the start
  - One from the end
- Skip non-alphanumeric characters on the fly
- Compare characters in lowercase

---

### Approach:
- Initialize two pointers:
  - `left` at the beginning
  - `right` at the end
- While `left < right`:
  - Move `left` forward if it points to a non-alphanumeric character
  - Move `right` backward if it points to a non-alphanumeric character
  - Compare lowercase characters at both pointers
  - If mismatch found, return `false`
- If loop completes, return `true`

---

### Code for Optimized Solution

    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {

                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }

                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }

---

### Time complexity - O(n)
- Each character is visited at most once

### Space complexity - O(1)
- No extra data structures are used

---

### Interview One-Liner
- I use a two-pointer approach to compare characters from both ends while skipping non-alphanumeric characters and ignoring case, which allows checking palindromes in O(n) time and O(1) space.

---
