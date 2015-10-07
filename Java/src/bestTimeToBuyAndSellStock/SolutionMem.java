/**
 * The Solution which makes use of memoization.
 * Time complexity: O(n).
 * Space complexity: O(n);
 * Status: StackOverFlow Error;
 */
public class SolutionMem {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] result = dfs(prices, prices.length);
        return result[1];
    }

    private int[] dfs(int[] prices, int n) {
        if (n == 1) {
            int[] minAndProf = new int[2];
            minAndProf[0] = prices[0];
            minAndProf[1] = 0;
            return minAndProf;
        }

        int[] minAndProf = dfs(prices, n - 1);
        minAndProf[0] = Math.min(minAndProf[0], prices[n - 1]);
        minAndProf[1] =
            Math.max(minAndProf[1], prices[n - 1] - minAndProf[0]);
        return minAndProf;
    }
        
}
