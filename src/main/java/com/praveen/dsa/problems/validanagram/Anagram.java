package com.praveen.dsa.problems.validanagram;

/**
 * Logic: Arrays + Frequency
 * #########################
 * --> assuming only lowercase alphabets, take an array of size 26
 * --> formula to find array location for each character is [character - 'a']
 * --> for each character in firstString, increment its frequency at its location
 * --> for each character in secondString, decrement its frequency at its location
 * --> iterate through frequency array, if value other than 0 found, then not anagrams
 * #########################
 * Time complexity = O(n) -- multiple for loops but not nested
 * Space complexity = O(1) -- integer array of size 26
 */
public class Anagram {

    public static void main(String[] args) {
        String firstString = "geeks";
        String secondString = "sgkee";
        boolean result = isAnagram(firstString, secondString);
        if (result) {
            System.out.println(firstString + " & " + secondString + " are anagrams");
        } else {
            System.out.println(firstString + " & " + secondString + " are not anagrams");
        }

    }

    private static boolean isAnagram(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < firstString.length(); i++) {
            frequency[firstString.charAt(i) - 'a']++;
        }

        for (int i = 0; i < secondString.length(); i++) {
            frequency[secondString.charAt(i) - 'a']--;
        }

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
