/* one dimensional DP solution
 * space compexity: o(n)
 * status: accepted, 240ms.
 */
public class Solution_DP_Opt {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            int last = 0;
            for (int j = 0; j < n; j++) {
                dp[j] += last;
                last = dp[j];
            }
        }

        return dp[n - 1];
    }
}
