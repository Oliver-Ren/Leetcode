/**
 * The divide and conquer and dp approach. 
 * calculate the max profit of the left and right
 * side of curr index for each indexes. and find the 
 * maximum.
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Status: Accepted, 7ms.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // precondition: prices is not null
        if (prices == null) throw new NullPointerException();
        if (prices.length < 2) return 0;

        int len = prices.length;
       
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        int min = prices[0];
        int max = prices[len - 1];

        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] - min);
        }

        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            rightMax[i] = Math.max(rightMax[i + 1], max - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, leftMax[i] + rightMax[i]);
        }

        return maxProfit;
    }
}
            


