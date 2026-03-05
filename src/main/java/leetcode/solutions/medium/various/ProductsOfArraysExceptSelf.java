package leetcode.solutions.medium.various;

/**
 * Pattern: Prefix & Suffix
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class ProductsOfArraysExceptSelf {
        public int[] productExceptSelf(int[] nums) {
                int n = nums.length;
                int[] res = new int[n];
                int[] prefix = new int[n];
                int[] suffix = new int[n];

                prefix[0] = 1;
                suffix[n - 1] = 1;

                // calculate prefix
                for (int i = 1; i < prefix.length; i++) {
                    prefix[i] = nums[i - 1] * prefix[i - 1];
                }

                // calculate suffix
                for (int i = n - 2; i >= 0; i--) {
                    suffix[i] = nums[i + 1] * suffix[i + 1];
                }

                for (int i = 0; i < res.length; i++) {
                    res[i] = prefix[i] * suffix[i];
                }
                return res;
    }
}
