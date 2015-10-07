/**
 * The simple naive solution for the problem.
 * Time complexity: O(n^2).
 * Space complexity: O(1);
 * Status: TLE;
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxDiff = Math.max(prices[j] - prices[i], maxDiff);
            }
        }
        return maxDiff;
    }
}
