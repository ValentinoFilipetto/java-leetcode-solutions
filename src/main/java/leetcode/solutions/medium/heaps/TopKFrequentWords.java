package leetcode.solutions.medium.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Pattern: max-heap
 * Time complexity: O(n log k), where k is the number of unique words in the input.
 * Space complexity: O(n)
 * Intuition: use a min-heap to be able to poll from it as soon as we get past k values (trick for O(n log k))
 * but reverse res so that we get the right order for the expected output list.
 */

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequenciesMap = new HashMap<>();

        for (String word : words) {
            frequenciesMap.computeIfAbsent(word, key -> 0);
            frequenciesMap.put(word, frequenciesMap.get(word) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(
            // Comparator.reverseOrder() is needed because this is a min-heap,
            // so the weakest candidate to be eliminated will be the one with the smallest
            // lexicographic value, but we do not want that.
            // This makes this optimization if (minHeap.size() > k) minHeap.poll(); work.
            Comparator.comparingInt((String s) -> frequenciesMap.get(s))
                      .thenComparing(Comparator.reverseOrder())
        );

        for (Map.Entry<String, Integer> e : frequenciesMap.entrySet()) {
            minHeap.offer(e.getKey());
            if (minHeap.size() > k) minHeap.poll();
        }

        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) res.add(minHeap.poll());
        Collections.reverse(res);
        return res;
    }
}
