package leetcode.solutions.medium.heaps;

import java.util.PriorityQueue;

/**
 * Pattern: MinHeap
 * Time complexity: O(n * log n)
 * Space complexity: O(n)
 */

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // We do the sorting of distances on the fly in the min heap.
        // This is much better than calculating distances separately as it leads to the issue
        // that we have distances in the heap, and it is hard to fetch points later for the response.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    return ((a[0] * a[0]) + (a[1] * a[1])) - ((b[0] * b[0]) + (b[1] * b[1]));
                }
        );

        for (int[] point : points) minHeap.offer(point);

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}
