package leetcode.solutions.medium.heaps;

import java.util.PriorityQueue;

/**
 * Pattern: MinHeap
 * Time complexity: O(n * log k)
 * Space complexity: O(k)
 */

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
