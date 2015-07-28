/** A dynamic programming solution 
  * Time compexity is O(n^2)
  * Space complexity is O(n)
  * Status:Accepted, 220ms.
  */

public class Solution_DP {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        int [] dp = new int[n+1];
        dp[0] = 1;
        for (int num = 1; num <= n; num++) {
            for (int i = 1; i <= num; i++) {
                dp[num] += dp[i - 1] * dp[num - i];
            }
        }

        return dp[n];
        

            
            
    }


    public static void main(String[] args) {
        Solution_DP test = new Solution_DP();
        System.out.println(test.numTrees(4));
    }
}



