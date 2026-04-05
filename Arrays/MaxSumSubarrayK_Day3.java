// Day: 3
// Problem: Max Sum Subarray of Size K
// Platform: LeetCode / GFG
// Topic: Array + Sliding Window
// Approach: Fixed Size Sliding Window
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Check all subarrays of size k → O(n*k)

// Optimal:
// Use sliding window → add next element, remove previous → O(n)

public class MaxSumSubarrayK {

    /**
     * Function to find maximum sum of subarray of size k
     */
    public static int maxSum(int[] nums, int k) {

        // Edge case
        if (nums == null || nums.length < k) {
            return 0;
        }

        int windowSum = 0;

        // Step 1: Calculate first window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < nums.length; i++) {

            windowSum += nums[i];      // Add next element
            windowSum -= nums[i - k];  // Remove previous element

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSum(nums, k);

        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
}