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
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (res.getLast()[1] < intervals[i + 1][0]) {
                res.add(intervals[i + 1]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i + 1][1]);
            }
        }
        return res.toArray(new int[0][]);
    }
}
