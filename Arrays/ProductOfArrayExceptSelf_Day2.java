// Day: 2
// Problem: Product of Array Except Self
// Platform: LeetCode
// Topic: Array + Prefix/Suffix
// Time Complexity: O(n)
// Space Complexity: O(1) (excluding output array)

// Brute Force:
// For each element, multiply all others → O(n^2)

// Optimal:
// Use prefix and suffix product without extra arrays

public class ProductOfArrayExceptSelf_Day2 {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Store prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;
    }

    //  Main method for testing
    public static void main(String[] args) {

        ProductOfArrayExceptSelf_Day2 obj = new ProductOfArrayExceptSelf_Day2();

        int[] nums = {1, 2, 3, 4};

        int[] result = obj.productExceptSelf(nums);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}