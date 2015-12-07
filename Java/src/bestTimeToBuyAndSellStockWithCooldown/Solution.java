/**
 * Dynamic Programming Approach.
 * Time Complexity: O(n).
 * Space Complexity: O(n).
 * Status: Accepted, 5ms.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // precondition: prices is not null
        if (prices == null) throw new NullPointerException();
        if (prices.length == 0) return 0;
        int len = prices.length;
        int[] optBuy = new int[len + 1];
        int[] optSell = new int[len + 1];

       
        int prev = 0;
        int optProfit = 0;
        for (int i = 0; i < len; i++) {
            int delta = prices[i] - prev; 
            if (i > 0) {
                optBuy[i + 1] = Math.max(optSell[i - 1] - prices[i], optBuy[i] - delta);
                optSell[i + 1] = Math.max(optBuy[i] + prices[i], optSell[i] + delta);
            } else {
                optSell[i + 1] = 0;
                optBuy[i + 1] = -prices[0];
            }
            int optCurr = Math.max(optSell[i + 1], optBuy[i + 1]);

            optProfit = Math.max(optCurr, optProfit);
            prev = prices[i];
        }

        return optProfit;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,0,2};
        System.out.println(s.maxProfit(nums));
    }
}
