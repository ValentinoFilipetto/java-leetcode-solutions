package leetcode.solutions.easy.various;

/**
 * Pattern: Prefix Sum
 * Time complexity: constructor takes O(n), while sumRange() takes O(1)
 * Space complexity: O(n)
 */

public class RangeSumQueryImmutable {
    private int[] prefix;

    public RangeSumQueryImmutable(int[] nums) {
        // We want first value of prefix to be 0, so we set nums.length + 1
        // This is needed for later, to facilitate calculations.
        prefix = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
