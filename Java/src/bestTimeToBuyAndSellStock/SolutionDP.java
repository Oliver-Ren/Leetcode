/**
 * The basic DP solution
 * states: f(i) represents the maximum profix could be achieved
 * until i.
 * recurrence: f(i) = max(f(i - 1), max(prices[i] - prices[k]))
 * init: f(0) = 0;
 * answer: f(n);
 */
public class SolutionDP {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 1];
        int min = prices[0];
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, prices[i - 1]);
            f[i] = Math.max(f[i - 1], prices[i - 1] - min);
        }
        return f[n];
    }
}
