// Day: 2
// Problem: Maximum Subarray
// Platform: LeetCode
// Topic: Array + Greedy (Kadane's Algorithm)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Check all subarrays → O(n^2)

// Optimal:
// Use Kadane's Algorithm → Track current sum and max sum

public class MaximumSubarray_Day2 {

    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];   // Store maximum sum
        int currentSum = 0;     // Running sum

        for (int num : nums) {

            // If current sum becomes negative, reset it
            if (currentSum < 0) {
                currentSum = 0;
            }

            // Add current number
            currentSum += num;

            // Update max sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    //  Main method for testing
    public static void main(String[] args) {

        MaximumSubarray_Day2 obj = new MaximumSubarray_Day2();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int result = obj.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}