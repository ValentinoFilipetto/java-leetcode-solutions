package leetcode.solutions.hard.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time complexity: O(n log n)
 * Space complexity: O(n)
 * Notes:
 * - We store capitals in a minHeap as lower capitals are more likely to be picked up.
 * - We store profits in a maxHeap as our goal is to maximise w at each step. Because spending capitals does not impact w, 
 * we don't need to be `strategic` on what capital we are choosing. We only need to maximise profit at each step.
 */

public class IPO {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> smallCapitals = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // minHeap
        Queue<Integer> largeProfits = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // maxHeap

        for (int i = 0; i < capital.length; i++) smallCapitals.offer(new int[] {capital[i], profits[i]});

        for (int i = 0; i < k; i++) {
            while (!smallCapitals.isEmpty() && smallCapitals.peek()[0] <= w) {
                largeProfits.offer(smallCapitals.poll()[1]);
            }

            if (largeProfits.isEmpty()) break;

            w += largeProfits.poll();
        }
        return w;
    }
}
