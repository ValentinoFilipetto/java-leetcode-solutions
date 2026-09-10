package leetcode.solutions.easy.twopointers;

/**
 * Pattern: Three Pointers
 * Time complexity: O(m + n)
 * Space complexity: O(1)
 * Intuition: we compare 'last elements' from nums1 and nums2,
 * and place the bigger at the end of nums1, leveraging the fact that
 * nums1 and nums2 are sorted in non-decreasing order.
 */


public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[last] = nums1[m - 1];
                m--;
            } else {
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }
        
        // Edge case: m = 0 while n > 0,
        // e.g. nums1 = [0, 0], m = 0, nums2 = [1, 2], n = 2
        // We just copy the elements of nums2 into nums1.
        while (n > 0) {
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
    }
}
