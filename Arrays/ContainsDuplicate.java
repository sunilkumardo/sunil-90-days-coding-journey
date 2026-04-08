// Day: 6
// Problem: 217. Contains Duplicate
// Platform: LeetCode
// Topic: Array + HashSet
// Approach: Use HashSet to track seen elements
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// Compare every pair → O(n^2)

// Optimal:
// Use HashSet → if element already exists → duplicate found

import java.util.*;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            // If already exists → duplicate found
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        boolean result = containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);
    }
}