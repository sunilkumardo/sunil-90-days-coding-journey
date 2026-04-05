// Day: 3
// Problem: Container With Most Water
// Platform: LeetCode
// Topic: Array + Two Pointers
// Approach: Two Pointer (Greedy)
// Time Complexity: O(n)
// Space Complexity: O(1)

// Brute Force:
// Check all pairs → O(n^2)

// Optimal:
// Use two pointers → move pointer with smaller height

public class ContainerWithMostWater_Day3 {

    /**
     * Function to find maximum water container
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;

            int area = minHeight * width;

            maxArea = Math.max(maxArea, area);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println("Maximum water that can be contained: " + result);
    }
}