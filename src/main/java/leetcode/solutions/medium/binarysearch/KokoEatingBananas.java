package leetcode.solutions.medium.binarysearch;

import java.util.Arrays;

/**
 * Pattern: Binary Search
 * Time complexity: O(n * log m),
 * where m is the tallest pile and n is the number of elements in piles.
 * Space complexity: O(1)
 */

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;

        // Math.min only works on two primitive values.
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;

        while (left <= right) {
            int rate = (left + right) / 2;

            int hoursRequired = getHoursRequired(piles, rate);

            if (hoursRequired > h) {
                left = rate + 1;
            } else {
                right = rate - 1;
                res = Math.min(res, rate);
            }
        }
        return res;
    }

    private static int getHoursRequired(int[] piles, int rate) {
        int hoursRequired = 0;
        for (int pile : piles) {
            // We cast pile to double so the division keeps its decimal part; otherwise int division
            // would truncate the result (e.g., 7/3 becomes 2 instead of 2.333...). Math.ceil() needs
            // the decimal value to know whether to round up. After ceil() gives a whole-number hour
            // as a double (e.g., 3.0), we cast it back to int because hoursRequired stores integers.
            hoursRequired += (int) Math.ceil((double) pile / rate);
        }
        return hoursRequired;
    }
}
