// Day: 10
// Problem: 84. Largest Rectangle in Histogram
// Platform: LeetCode
// Topic: Stack (Monotonic Stack)
// Approach: Use stack to find previous & next smaller elements
// Time Complexity: O(n)
// Space Complexity: O(n)

// Brute Force:
// Check all rectangles → O(n^2)

// Optimal:
// Use stack to maintain increasing heights

import java.util.*;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        int result = largestRectangleArea(heights);

        System.out.println("Largest Rectangle Area: " + result);
    }
}