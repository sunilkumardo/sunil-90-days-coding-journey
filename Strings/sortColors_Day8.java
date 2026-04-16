// Day: 8
// Problem: 75. Sort Colors
// Platform: LeetCode
// Topic: Array + Sorting
// Approach: Dutch National Flag (3 Pointers)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Sort array → O(n log n)

// Optimal:
// Use 3 pointers (low, mid, high)
// 0 → left, 1 → middle, 2 → right

import java.util.*;

public class sortColors_Day8 {

    public static void sortColors(int[] nums) {

        int low = 0, mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                // Swap with low
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            else if (nums[mid] == 1) {
                mid++;
            }

            else {
                // Swap with high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        System.out.println("Sorted Array: " + Arrays.toString(nums));
    }
}