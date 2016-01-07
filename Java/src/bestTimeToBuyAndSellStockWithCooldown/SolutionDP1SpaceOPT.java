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
 * Since the hold and free only relies on the previous 2 statuses,
 * we could use constant space.
 *
 * Time Complexity: O(n);
 * Space Complexity: O(1);
 * Status: Accepted, 2ms.
 */
public class SolutionDP1 {
    public int maxProfit(int[] prices) {
         // precondition: prices is not null
        if (prices == null) throw new NullPointerException();
        int hold = Integer.MIN_VALUE;
        int prevFree = 0;
        int free = 0;
        
        for (int i = 0; i < prices.length; i++) {
            hold = Math.max(hold, prevFree - prices[i]);
            prevFree = free;
            free = Math.max(free, hold + prices[i]);
        }
        return Math.max(hold, free);
    }
}

