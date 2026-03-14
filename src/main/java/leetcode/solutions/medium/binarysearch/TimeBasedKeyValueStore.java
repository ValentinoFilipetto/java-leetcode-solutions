package leetcode.solutions.medium.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pattern: Binary Search
 * Time complexity: O(1) for set() and O(log n) for get().
 * Space complexity: O(n)
 */

record EntryPair(String name, int timestamp) {}

public class TimeBasedKeyValueStore {
    Map<String, List<EntryPair>> map;

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new ArrayList<>()).add(
                new EntryPair(value, timestamp)
        );
    }

    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) return "";

        List<EntryPair> list = this.map.get(key);
        int left = 0, right = list.size() - 1;
        String res = ""; // Use a variable to track the "closest" valid name

        while (left <= right) {
            int middle = left + (right - left) / 2; // Prevents potential overflow

            if (list.get(middle).timestamp() <= timestamp) {
                res = list.get(middle).name();
                left = middle + 1;
            } else {
                right = middle - 1; // Too big, look left
            }
        }
        return res;
    }
}
