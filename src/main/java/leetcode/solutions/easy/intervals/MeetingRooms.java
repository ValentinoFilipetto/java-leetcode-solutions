package leetcode.solutions.easy.intervals;

import java.util.List;

/**
 * Pattern: Intervals
 * Time complexity: O(n log n)
 * Space complexity: O(n) due to sorting algorithm.
 */

class Interval {
     public int start, end;
     public Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
 }

class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i + 1);
            if (i2.start < i1.end) return false;
        }
        return true;
    }
}
