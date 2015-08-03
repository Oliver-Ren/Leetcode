/* Status: Accetped. */
public class Solution_DP_1Dim {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [] dp = new int[n];
        dp[0] = 1;


        for (int i = 0; i < m; i++) { 
            dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
            for (int j = 1; j < n; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

