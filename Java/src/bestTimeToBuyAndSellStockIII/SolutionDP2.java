/**
 * Revisit the dynamic programming soluiton.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // prices is not null
        if (prices == null) throw new NullPointerException();
        if (prices.length == 0) return 0;
        
        int n = prices.length;
        int[] lmaxProfit = new int[n + 1];
        int[] rmaxProfit = new int[n + 1];
        int minPriceL = Integer.MAX_VALUE;
        int maxPriceR = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            minPriceL = Math.min(minPriceL, prices[i - 1]);
            lmaxProfit[i] = Math.max(lmaxProfit[i - 1], prices[i - 1] - minPriceL);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            maxPriceR = Math.max(maxPriceR, prices[i]);
            rmaxProfit[i] = Math.max(rmaxProfit[i + 1], maxPriceR - prices[i]);
        }
        
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            maxProfit = Math.max(maxProfit, rmaxProfit[i] + lmaxProfit[i]);
        }
        
        return maxProfit;
        
    }
}
