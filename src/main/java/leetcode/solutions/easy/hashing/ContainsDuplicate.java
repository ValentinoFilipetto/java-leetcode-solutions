package leetcode.solutions.easy.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Pattern: Hashing
 * Time complexity: O(n)
 * Space complexity: O(n)
 * */

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }

        return false;
    }
}
