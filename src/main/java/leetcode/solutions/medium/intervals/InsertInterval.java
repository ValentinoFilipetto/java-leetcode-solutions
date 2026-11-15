package leetcode.solutions.medium.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Intervals (Greedy)
 * Time complexity: O(n)
 * Space complexity: O(n)

 * Called greedy because at each step we make a locally optimal, irrevocable decision
 * about the current interval without backtracking:
 *   1. Add it as-is     — it ends before the new interval starts, so no overlap is possible.
 *   2. Flush then add   — it starts after the new interval ends, so the merge window is closed.
 *   3. Merge            — it overlaps, so we expand the new interval's bounds on the spot.

 * This works because the input is already sorted: once an interval is non-overlapping
 * to the left, no future interval can change that, so we never need to revisit a decision.
 */

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) res.add(intervals[j]);
                return res.toArray(new int[0][]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);
        // This conversion is needed to satisfy the return type int[][] requirement.
        // .toArray() converts res into int[][] by specifying the overall length
        // and then copying each int[] array into it.
        return res.toArray(new int[0][]);
    }
}