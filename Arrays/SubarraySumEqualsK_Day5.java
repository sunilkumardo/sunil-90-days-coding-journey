// Day: 5
// Problem: 560. Subarray Sum Equals K
// Platform: LeetCode
// Topic: Array + Prefix Sum + HashMap
// Approach: Prefix Sum + Frequency Map
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// Check all subarrays → O(n^2)

// Optimal:
// Use prefix sum and hashmap to track frequencies
// If (currentSum - k) exists → valid subarray found

import java.util.*;

public class SubarraySumEqualsK_Day5 {

    /**
     * Function to count subarrays with sum = k
     */
    public static int subarraySum(int[] nums, int k) {

        // Map to store prefix sum frequencies
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum = 0 occurs once
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            // Check if (currentSum - k) exists
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }

            // Update map with current sum
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays with sum " + k + ": " + result);
    }
}