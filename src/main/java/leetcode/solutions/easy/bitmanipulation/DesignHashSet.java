package leetcode.solutions.easy.bitmanipulation;

/**
 * Pattern: Bit Manipulation
 * Time complexity: O(1)
 * Space complexity: O(k)
 * Intuition: since the specs say that values will be in the range [1, 1000000],
 * we can keep an array with a slot for each value. If we use 32-bit integers, we can save a lot of space
 * compared to using booleans, namely 1000000 / 32 = 31250.
 */

public class DesignHashSet {
    private final int[] set;

    public DesignHashSet() {
        // key is in the range [1, 1000000]
        // 31251 * 32 = 1000032
        set = new int[31251];
    }

    public void add(int key) {
        set[key / 32] |= getMask(key);
    }

    public void remove(int key) {
        if (contains(key)) {
            set[key / 32] ^= getMask(key);
        }
    }


    /**
     * Example:
     * set[2] = ...00110010     → key 70 was never added, bit 6 is 0
     * mask   = ...01000000     → getMask(70)
     * set[2] & mask:
     *   00110010
     * & 01000000
     * ----------
     *   00000000  →  result = 0  → key 70 does not exist
     */
    public boolean contains(int key) {
        return (set[key / 32] & getMask(key)) != 0;
    }

    /**
     * Example:
     * key = 70
     * key / 32 = 2           → int at index 2
     * key % 32 = 6           → bit 6 within that int
     * getMask(70) = 1 << 6   → 01000000
     * set[2] = ...01000000   → bit 6 is ON, meaning key 70 exists
     */
    private int getMask(int key) {
        return 1 << (key % 32);
    }
}