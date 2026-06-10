package leetcode.solutions.easy.various;

/**
 * Pattern: Boyer-Moore Voting Algorithm
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Intuition:  The majority element (appearing > n/2 times) will always "survive" a cancellation battle against all other elements combined.
 * Think of it like a vote war:
 * - Every element "votes" for itself
 * - When two different elements meet, they cancel each other out
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (num == res) ? 1 : -1;
        }
        return res;
    }
}
