import java.util.*;

/** the cached DFS solution.
  * time complexity: O(n^2), where n 
  * is the height of the triangle.
  * space complexity: O(n).
  * Status: Accepted, 264ms.
  */

public class Solution_DP_Topdown {
    public int minimumTotal(List<List<Integer>> triangle) {
       int[][] dp = new int[triangle.size() + 1][triangle.size() + 2];

       for (int i = 0; i < dp.length; i++) {
           for (int j = 0; j < i + 2; j++) {
               dp[i][j] = Integer.MAX_VALUE;
           }
       }

       dp[0][0] = 0;

       for (int i = 1; i < dp.length; i++) {
           for (int j = 1; j <= i; j++) {
               dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j])
                   + triangle.get(i - 1).get(j - 1);
           }
       }

       int min = Integer.MAX_VALUE;
       for (int i = 1; i < dp.length; i++) {
           min = Math.min(min, dp[dp.length - 1][i]);
       }

       return min;
    }

}

        
