# Best Time to Buy and Sell Stock

---

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `iᵗʰ` day.

You want to maximize your profit by choosing **a single day to buy one stock** and choosing **a different day in the future to sell that stock**.

Return the **maximum profit** you can achieve from this transaction.  
If no profit is possible, return `0`.

### Simple Explanation:
Buy the stock at the **lowest possible price** and sell it later at a **higher price** to get maximum profit.

---

## Examples

**Input 1:**
- `prices = [7,1,5,3,6,4]`

**Output:** `5`  
**Explanation:** Buy at price `1` and sell at price `6`, so profit will be  `6 - 1 = 5`.

---

**Input 2:**
- `prices = [7,6,4,3,1]`

**Output:** `0`  
**Explanation:** Prices are decreasing, so no profit is possible.

---

## 1. Naive Solution

### Approach:
- Pick one day to buy the stock
- Try selling it on every future day
- Calculate the profit for every possible buy-sell pair
- Keep track of the maximum profit

### Code for Naive Solution

    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;

            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
            return maxProfit;
        }
    }

### Time complexity - O(n²)
- Two nested loops check all possible buy-sell pairs

### Space complexity - O(1)
- No extra data structures are used

---

## 2. Optimized Solution

### Key Insight
- Instead of checking all future prices for every day, we can:
    - Track the **minimum price seen so far**
    - At each day, calculate the profit if we sell on that day
- This allows us to solve the problem in a **single pass**

### Approach:
- Initialize:
    - `minPrice` as the first day’s price
    - `maxProfit` as `0`
- Traverse the array from left to right
- For each day:
    - If the current price is lower than `minPrice`, update `minPrice`
    - Otherwise, calculate profit using:
      ```
      currentPrice - minPrice
      ```
    - Update `maxProfit` if this profit is higher
- Return `maxProfit`

### Code for Optimized Solution

    class Solution {
        public int maxProfit(int[] prices) {

            if (prices == null || prices.length == 0) {
                return 0;
            }

            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else {
                    int profit = prices[i] - minPrice;
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
            return maxProfit;
        }
    }

### Time complexity - O(n)
- We traverse the array only once

### Space complexity - O(1)
- Only constant extra variables are used

---

### Interview One-Liner
I track the minimum price seen so far and, for each day, calculate the profit if I sell on that day.  
This allows me to find the maximum profit in a single pass with O(n) time complexity.

---

