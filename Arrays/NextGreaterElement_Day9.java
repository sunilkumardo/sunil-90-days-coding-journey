// Day: 9
// Problem: 496. Next Greater Element I
// Platform: LeetCode
// Topic: Stack + HashMap
// Approach: Monotonic Stack
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// For each element, check next greater → O(n^2)

// Optimal:
// Use stack to maintain decreasing order
// Map each element to its next greater

import java.util.*;

public class NextGreaterElement_Day9 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Build next greater map from nums2
        for (int num : nums2) {

            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Remaining elements have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}