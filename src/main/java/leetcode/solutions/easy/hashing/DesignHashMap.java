package leetcode.solutions.easy.hashing;

import java.util.Arrays;

/**
 * Pattern: Hashing
 * Time complexity: O(1) for all the methods
 * Space complexity: O(1000001)
 */

public class DesignHashMap {
    int[] map;

    public DesignHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        if (map[key] != -1) return map[key];
        else return -1;
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
