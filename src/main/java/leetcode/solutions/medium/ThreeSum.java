package leetcode.solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pattern: Two Pointers + Sorting
 * Time complexity: O(n^2), because of the combination of outer for and inner while loops.
 * Space complexity: O(log n) for the sorting algorithm.
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // do NOT start from i = 1 as we would miss this case: [0, 0, 0].
        // Start from i = 0 and check if i > 0 below.
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
