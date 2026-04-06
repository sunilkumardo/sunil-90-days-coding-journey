// Day: 4
// Problem: Minimum Window Substring
// Platform: LeetCode
// Topic: String + Sliding Window
// Approach: Variable Window + HashMap (Frequency Count)
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// Check all substrings → O(n^3)

// Optimal:
// Use two pointers + frequency map to track required characters

import java.util.*;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();

        // Count characters in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = map.size();
        int formed = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if current char satisfies requirement
            if (map.containsKey(c) &&
                windowMap.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Try to shrink window
            while (left <= right && formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (map.containsKey(leftChar) &&
                    windowMap.get(leftChar) < map.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);

        System.out.println("Minimum window substring: " + result);
    }
}