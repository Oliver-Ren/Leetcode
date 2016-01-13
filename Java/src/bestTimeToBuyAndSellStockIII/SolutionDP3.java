/**
 * The dynamic programming approach. 
 * State: hold1(i) represents the maximum profit while holding stocks at i in
 *        the first transaction. 
 *        free1(i) represents the maximum profit while not holding stocks at i
 *        int the first transaction.
 *        hold2(i) represent the maximum profit . .... 2nd...
 *        free2(i) ...... 2nd .....
 * Recurrence: hold1(i) = max(hold1(i - 1), empty(i - 1) - price(i)).
 *             
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
            


