/**
 * The dynamic programming approach.
 * State: hold(i) represents at the time i the
 * maximum profit achievable when holding stocks;
 * free(i) represents at the time i the maximum profit
 * achievable when not holding stocks;
 * Recurrence: hold(i) = max(hold(i - 1), free(i - 2) - price(i))
 *             free(i) = max(free(i - 1), hold(i - 1) + price(i))
 * Initialize: hold(-2) = -inf, hold(-1) = -inf, free(-2) = 0 free(-1) = 0.
 * Answer: max(hold(n), free(n))
 * 
 * Time Complexity: O(n);
 * Space Complexity: O(n);
 * Status: Accepted, 2ms.
 */
public class SolutionDP1 {
    public int maxProfit(int[] prices) {
        // precondition: prices is not null
        if (prices == null) throw new NullPointerException();
        int n = prices.length;
        int[] hold = new int[n + 2];
        int[] free = new int[n + 2];

        hold[0] = Integer.MIN_VALUE;
        hold[1] = Integer.MIN_VALUE;

        for (int i = 2; i < n + 2; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 2] - prices[i - 2]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i - 2]);
        }

        return Math.max(hold[n + 1], free[n + 1]);
    }
}
