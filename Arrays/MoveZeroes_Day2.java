// Day: 2
// Problem: Move Zeroes
// Platform: LeetCode
// Topic: Array + Two Pointers
// Approach: Two Pointer (In-place swap)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Create new array, copy non-zero elements, then add zeros → O(n) space

// Optimal:
// Use two pointers to move non-zero elements forward and push zeros to end

public class MoveZeroes_Day2 {

    public void moveZeroes(int[] nums) {

        int j = 0; // Pointer for placing non-zero elements

        for (int i = 0; i < nums.length; i++) {

            // If current element is non-zero
            if (nums[i] != 0) {

                // Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // Move j forward
                j++;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        MoveZeroes_Day2 obj = new MoveZeroes_Day2();

        int[] nums = {0, 1, 0, 3, 12};

        obj.moveZeroes(nums);

        // Print result
        System.out.print("Output: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}