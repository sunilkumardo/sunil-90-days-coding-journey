
// Day: 5
// Problem: Maximum Subarray (Kadane’s Algorithm)
// Platform: LeetCode
// Topic: Array + Dynamic Programming
// Approach: Kadane’s Algorithm (Greedy + DP)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Check all subarrays → O(n^2)

// Optimal:
// If current sum becomes negative → reset to 0
// Keep track of maximum sum seen so far

public class maxSubArray_Day5 {

    /**
     * Function to find maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {

        // Initialize result with first element
        int res = nums[0];

        // Running sum
        int total = 0;

        for (int n : nums) {

            // If total becomes negative, reset it
            if (total < 0) {
                total = 0;
            }

            total += n;

            // Update maximum result
            res = Math.max(res, total);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}