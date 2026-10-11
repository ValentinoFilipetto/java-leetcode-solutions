package leetcode.solutions.medium.heaps;

import java.util.PriorityQueue;

/**
 * Pattern: max-heap/greedy
 * Time complexity: O(n), where n = a + b + c.
 * Space complexity: O(1), excluding res.
 * Intuition: store frequencies of a, b and c in maxHeap, so that we can retrieve the most frequent
 * quickly and greedily place it in the resulting string as soon as possible.
 */

public class LongestHappyString {
    public String longestHappyString(int a, int b, int c) {
        // [letter, frequency]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (x, y) -> Integer.compare(y[1], x[1])
        );

        if (a > 0) maxHeap.offer(new int[] { 'a', a });
        if (b > 0) maxHeap.offer(new int[] { 'b', b });
        if (c > 0) maxHeap.offer(new int[] { 'c', c });

        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();

            if (canAppend(res, first)) {
                res.append((char) first[0]);
                first[1]--;
                if (first[1] > 0) maxHeap.offer(first);
            } else {
                if (maxHeap.isEmpty()) break;
                int[] second = maxHeap.poll();
                maxHeap.offer(first);
                res.append((char) second[0]);
                second[1]--;
                if (second[1] > 0) maxHeap.offer(second);
            }
        }
        return res.toString();
    }

    /** Character can be appended only if either res is shorter than 2
     * or appending it will not create a sequence of 3 equal characters. */
    private boolean canAppend(StringBuilder res, int[] current) {
        return res.length() < 2 || 
               (char) current[0] != res.charAt(res.length() - 1) ||
               current[0] != res.charAt(res.length() - 2);
    }
}
