package leetcode.solutions.medium.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Pattern: Sliding Window (Deque)
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Intuition: the array is sorted, so the element farthest from x in any window is always
 * one of its endpoints. When the window exceeds k, drop the endpoint that is farther from x.
 */


public class FindKClosestElements {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            deque.addLast(arr[i]);

            if (deque.size() > k) {
                int a = deque.peekFirst();
                int b = deque.peekLast();

                if (Math.abs(a - x) <= Math.abs(b - x)) deque.removeLast();
                else deque.removeFirst();
            }
        }
        return new ArrayList<>(deque);
    }
}
