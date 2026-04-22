package leetcode.solutions.easy.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Pattern: Heaps (min-heap)
 * Time complexity: O(n log n)
 * Space complexity: O(n), where n is the number of stones.
 */

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) maxHeap.add(stone);

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            // `offer` is more idiomatic for queue than `add`.
            if (x > y) maxHeap.offer(x - y);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
