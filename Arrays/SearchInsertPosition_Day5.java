// Day: 7
// Problem: 35. Search Insert Position
// Platform: LeetCode
// Topic: Array + Binary Search
// Approach: Binary Search (Lower Bound)
// Time Complexity: O(log n)
// Space Complexity: O(1)

// Brute Force:
// Linear scan → O(n)

// Optimal:
// Binary search to find correct insert position

public class SearchInsertPosition_Day5 {

    public static int searchInsert(int[] nums, int target) {

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

        // Insert position
        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int result = searchInsert(nums, target);

        System.out.println("Insert Position: " + result);
    }
}
