package leetcode.solutions.medium.sorting;

/**
 * Pattern: Counting Sort
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class SortColors {
    public void sortColors(int[] nums) {
        int[] frequencies = new int[3];

        for (int num : nums) frequencies[num]++;

        for (int i = 0; i < nums.length; i++) {
            if (frequencies[0] > 0) {
                nums[i] = 0;
                frequencies[0]--;
            } else if (frequencies[1] > 0) {
                nums[i] = 1;
                frequencies[1]--;
            } else {
                nums[i] = 2;
                frequencies[2]--;
            }
        }
    }
}
