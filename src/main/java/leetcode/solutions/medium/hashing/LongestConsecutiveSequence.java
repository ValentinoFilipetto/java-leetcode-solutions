package leetcode.solutions.medium.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Pattern: Hashing
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int maxLength = 0;
        for (int num: nums) {
            if (set.contains(num - 1)) continue;
            else {
                int length = 1, curNum = num + 1;
                while (set.contains(curNum)) {
                    curNum++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
