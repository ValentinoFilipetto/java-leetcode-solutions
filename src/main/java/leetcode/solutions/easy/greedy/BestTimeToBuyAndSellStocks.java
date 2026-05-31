package leetcode.solutions.easy.greedy;

/**
 * Patter: Greedy (sliding window structurally)
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int left = 0, maxSoFar = 0;

        for (int right = 0; right < prices.length; right++) {
            if (prices[right] <= prices[left]) left = right;
            else {
                int profit = prices[right] - prices[left];
                maxSoFar = Math.max(maxSoFar, profit);
            }
        }
        return maxSoFar;
    }
}
