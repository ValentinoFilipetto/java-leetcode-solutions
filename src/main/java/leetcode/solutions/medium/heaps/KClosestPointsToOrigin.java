package leetcode.solutions.medium.heaps;

import java.util.PriorityQueue;

/**
 * Pattern: max-heap
 * Time complexity: O(n * log k)
 * Space complexity: O(k)
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],
                                      a[0] * a[0] + a[1] * a[1]));
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            res[i++] = point;
        }
        return res;
    }
}