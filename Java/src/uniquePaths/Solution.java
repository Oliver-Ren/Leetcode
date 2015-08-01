/** DP solution.
  * time compleixty: O(m * n)
  * space complexity: O(m * n);
  * Status: Accepted, 244ms.
  */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        dp[0][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.uniquePaths(3,3));
    }
}

