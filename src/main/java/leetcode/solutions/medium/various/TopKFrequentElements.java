package leetcode.solutions.medium.various;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pattern: Bucket Sort (note: bucket sort ensures sorting because it is a list).
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); // element -> frequency
        List<Integer>[] frequencies = new List[nums.length + 1]; // Be mindful of off-by-one here.

        // Fill frequencies with empty buckets.
        for (int i = 0; i < frequencies.length; i++) {
            frequencies[i] = new ArrayList<>();
        }

        // Calculate frequencies.
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Add values to buckets based on frequencies.
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            frequencies[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = frequencies.length - 1; i > 0; i--) {
            for (int n : frequencies[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
