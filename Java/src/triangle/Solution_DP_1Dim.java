/** the bottom up 1 dimensional DP solution. 
  * time complexity: O(n ^ 2), where n 
  * is the height of the triangle.
  * space complexity: O(n).
  * Status: 304ms. 
  */

public class solution_DP_1Dim {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
