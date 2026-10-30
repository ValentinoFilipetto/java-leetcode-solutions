package leetcode.solutions.hard.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Pattern: Sliding Window (monotonically-decreasing deque)
 * Time complexity: amortized O(n)
 * Space complexity:
 * 
 * Notes:
 * - We use a deque, which is a queue where we can add and remove elements from both front and back.
 * - Deque is storing indices of nums in decreasing order of their values.
 * The deque stays ordered by:
 * - Age: oldest index at the front.
 * - Value: largest value at the front, to be quickly retrieved.
 */


public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // We count the number of 'starting position' for the window.
        // The number of starting position is nums.length − k + 1.
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            // If current value is bigger then values of deque, remove them.
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) q.removeLast();

            q.addLast(r);
            
            // Remove values from deque that 'fell' out of the window.
            // Indices in deque increase from front to back, so q.getFirst() is always the oldest index.
            // l, on the other hand, marks the beginning of the window.
            if (l > q.getFirst()) q.removeFirst();
            
            // If window is full, add maximum value (q.getFirst()) to the output.
            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return res;
    }
}
