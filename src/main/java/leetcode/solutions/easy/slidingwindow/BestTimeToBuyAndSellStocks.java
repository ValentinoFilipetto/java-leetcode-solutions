package leetcode.solutions.easy.slidingwindow;

/**
 * Patter: Greedy (sliding window structurally)
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Intuition:
 * - If a profit *cannot* be made, start a new window: we found a smaller value, so we might as well check if a profit can be made with that.
 * - As long as a profit *can* be made, calculcate it and keep track of curMax.
 */

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int curMax = 0;
        int l = 0;
        int r = 0;

        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l++;
                r = l;
            } else {
                int profit = prices[r] - prices[l];
                curMax = Math.max(curMax, profit);
            }
            r++;
        }
        return curMax;
    }
}
