// Day: 7
// Problem: 704. Binary Search
// Platform: LeetCode
// Topic: Array + Binary Search
// Approach: Iterative Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)

// Brute Force:
// Linear search → O(n)

// Optimal:
// Divide search space in half each time → O(log n)

public class BinarySearch_Day5 {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = search(nums, target);

        System.out.println("Target Index: " + result);
    }
}