package leetcode.solutions.medium.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Pattern: max-heap
 * Time complexity: O(m * n)
 * Space complexity: O(1) excluding resulting list, as each max-heap gets garbage-collected after the iteration when it is used.
 * Intuition: store top-3 lexicographical products in a minHeap for each prefix and send them to the result.
 */

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            res.add(new ArrayList<>());

            PriorityQueue<String> maxHeap = new PriorityQueue<>(
                    Comparator.reverseOrder()
            );

            for (String product : products) {
                if (product.startsWith(prefix)) maxHeap.offer(product);
                // This prevents us from having to sort dozens of products in the max-heap,
                // but requires reversing later.
                if (maxHeap.size() > 3) maxHeap.poll();
            }

            while (!maxHeap.isEmpty()) res.get(i).add(maxHeap.poll());
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
