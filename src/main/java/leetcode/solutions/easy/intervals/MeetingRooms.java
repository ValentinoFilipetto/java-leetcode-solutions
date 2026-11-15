package leetcode.solutions.easy.intervals;

import leetcode.solutions.types.Interval;

import java.util.List;

/**
 * Pattern: Intervals
 * Time complexity: O(n log n)
 * Space complexity: O(n) due to sorting algorithm.
 */

class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) return false;
        }
        return true;
    }
}
