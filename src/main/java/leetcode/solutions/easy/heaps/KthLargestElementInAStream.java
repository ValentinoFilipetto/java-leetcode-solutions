package leetcode.solutions.easy.heaps;

import java.util.PriorityQueue;

/**
 * Pattern: min-heap
 * Time complexity: constructor takes O(n * log k), where n is the number of values in nums
 * add() takes O(log k) time complexity.
 * Space complexity: O(k)
 */

public class KthLargestElementInAStream {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) minHeap.poll();

        return minHeap.peek();
    }
}
