package leetcode.solutions.medium.intervals;

import java.util.Arrays;

/**
 * Pattern: Intervals (Greedy)
 * Time complexity: O(n * log n)
 * Space complexity: O(n)
 */

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int lastEnd = intervals[0][1];
        int res = 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] < lastEnd) {
                res++;
                lastEnd = Math.min(lastEnd, intervals[i + 1][1]);
            } else {
                // We did not remove an interval, so we make sure to update lastEnd with the latest interval end.
                // lastEnd = intervals[i + 1][1] would also work, but we prefer a more explicit version.
                lastEnd = Math.max(lastEnd, intervals[i + 1][1]);
            }
        }
        return res;
    }
}
