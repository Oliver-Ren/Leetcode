/**
 * The Solution wiht only one scan of the array.
 * Time complexity: O(n).
 * Space complexity: O(1);
 * Status: Accepted, 2ms;
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int minTillNow = Integer.MAX_VALUE;
        int maxDiff = 0; 
        for (int i = 0; i < prices.length; i++) {
            minTillNow = Math.min(minTillNow, prices[i]);
            maxDiff = Math.max(maxDiff, prices[i] - minTillNow);
        }
        return maxDiff;
    }
}
