package leetcode.solutions.easy.greedy;

/**
 * Patter: Greedy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int start = i;

            // Check all profits we can make by buying at start and update maxSoFar.
            while (i < prices.length - 1 && prices[start] < prices[i + 1]) {
                maxSoFar = Math.max(maxSoFar, prices[i + 1] - prices[start]);
                i++;
            }
        }
        return maxSoFar;
    }
}
