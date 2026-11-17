package leetcode.solutions.medium.intervals;

import java.util.Arrays;

/**
 * Pattern: Intervals (Greedy)
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 */

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int lastEnd = intervals[0][1];
        int numberOfRemovals = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            if (lastEnd > intervals[i + 1][0]) {
                numberOfRemovals++;
                lastEnd = Math.min(lastEnd, intervals[i + 1][1]);
            } else {
                lastEnd = Math.max(lastEnd, intervals[i + 1][1]);
            }
        }
        return numberOfRemovals;
    }
}
