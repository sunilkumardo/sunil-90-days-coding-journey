// Day: 1
// Problem: Two Sum II - Input Array is Sorted
// Platform: LeetCode
// Topic: Two Pointers
// Approach: Two Pointer (Left & Right)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Use two loops → O(n^2)

// Optimal:
// Since array is sorted, use two pointers



public class TwoSumII_Day1 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII_Day1 obj = new TwoSumII_Day1();
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] res = obj.twoSum(numbers, target);
        System.out.println(res[0] + " " + res[1]);
    }
}