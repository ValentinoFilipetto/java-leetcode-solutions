package leetcode.solutions.medium.heaps;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.solutions.types.Interval;

/**
 * Pattern: min-heap
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 */

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        // minHeap contains the "rooms" currently in use, sorted by what becomes available first.
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            // If there is a conflict, add one more room, otherwise, remove the room in use
            // and add a new one, which will have an updated end time.
            if (minHeap.isEmpty() || interval.start < minHeap.peek()) {
                minHeap.offer(interval.end);
            } else {
                minHeap.poll();
                minHeap.offer(interval.end);
            }
        }
        return minHeap.size();
    }
}
