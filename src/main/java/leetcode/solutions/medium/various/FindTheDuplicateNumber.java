package leetcode.solutions.medium.various;

/**
 * Pattern: Negative Marking
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int index = Math.abs(num) - 1; // Absolute value is needed as `num` could be a value we negated.
            if (nums[index] < 0) {
                return Math.abs(num); // We return the number that would send us to a negated value, so a place we already visited.
            }
            nums[index] *= -1;
        }
        return -1;
    }
}
