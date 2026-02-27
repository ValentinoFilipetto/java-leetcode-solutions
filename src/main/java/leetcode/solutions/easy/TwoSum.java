package leetcode.solutions.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Pattern: Hashing
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (complementToIndex.containsKey(complement)) {
                int index = complementToIndex.get(complement);
                return new int[] { index, i };
            }
            complementToIndex.put(num, i);
        }
        return new int[] {};
    }
}
