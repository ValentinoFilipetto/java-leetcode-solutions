package leetcode.solutions.medium.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Pattern: max-heap
 * Time complexity: O(n log k), where k is the number of distinct characters in s. Since k <= 26, time simplifies to O(n).
 * Space complexity: O(n + k) including the result, or O(k) auxiliary space
 * Intuition: get quick access to most frequent letters via maxHeap, as we want to place them in res as soon as possible.
 */


public class ReorganizeString {
    public String reorganizeString(String s) {
        // [frequency, letter]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));
        Map<Character, Integer> frequencies = new HashMap<>();

        // Count frequencies of letters in s.
        for (char c : s.toCharArray()) {
            frequencies.computeIfAbsent(c, k -> 0);
            frequencies.put(c, frequencies.get(c) + 1);
        }

        // Place [frequency, letter] pair in maxHeap, in order to gain
        // access to the most frequent letters quickly.
        for (Map.Entry<Character, Integer> e : frequencies.entrySet()) {
            char letter = e.getKey();
            int frequency = e.getValue();
            maxHeap.add(new int[] { frequency, letter });
        }

        int[] previous = null;
        // We use StringBuilder as it is mutable (= less memory usage).
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();

            res.append((char) current[1]);
            current[0]--;

            if (previous != null && previous[0] > 0)
                maxHeap.add(previous);

            previous = current;
        }
        return res.length() == s.length() ? res.toString() : "";
    }
}
