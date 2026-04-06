// Day: 4
// Problem: Longest Substring Without Repeating Characters
// Platform: LeetCode
// Topic: String + Sliding Window
// Approach: Variable Size Sliding Window + HashSet
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// Generate all substrings and check uniqueness → O(n^3)

// Better:
// Use HashMap to track last index → O(n)

// Optimal:
// Sliding window + HashSet → expand & shrink window

import java.util.*;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // If duplicate found, shrink window
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Longest substring length: " + result);
    }
}