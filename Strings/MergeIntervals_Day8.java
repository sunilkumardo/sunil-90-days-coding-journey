// Day: 8
// Problem: 56. Merge Intervals
// Platform: LeetCode
// Topic: Array + Sorting
// Approach: Sort + Merge Overlapping Intervals
// Time Complexity: O(n log n)
// Space Complexity: O(n)

// Brute Force:
// Compare each interval with all others → O(n^2)

// Optimal:
// Sort intervals by start time
// Merge overlapping intervals

import java.util.*;

public class MergeIntervals_Day8 {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {

            // Overlapping case
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            }

            else {
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1,3}, {2,6}, {8,10}, {15,18}
        };

        int[][] result = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
