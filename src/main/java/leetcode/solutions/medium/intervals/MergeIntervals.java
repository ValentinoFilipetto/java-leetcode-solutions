package leetcode.solutions.medium.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pattern: Intervals (Greedy)
 * Time complexity: O(n * log n)
 * Space complexity: O(n)
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Remember: (a[0] - b[0]) <= 0, so a <= b, so a comes before b in the ordering.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] mergedInterval = intervals[0];
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length - 1; i++) {
            if (mergedInterval[1] < intervals[i + 1][0]) {
                res.add(mergedInterval);
                mergedInterval = intervals[i + 1];
            } else {
                mergedInterval[1] = Math.max(mergedInterval[1], intervals[i + 1][1]);
            }
        }
        res.add(mergedInterval);
        return res.toArray(new int[res.size()][]);
    }
}
