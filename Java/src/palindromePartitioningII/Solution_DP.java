import java.util.*;

/** This is a DP attempt for 
  * palindrome partitioning.
  * time complexity: O(n^2);
  * space complexity: O(n^2);
  * Status: Accpted, 352ms.
  */


public class Solution_DP {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length() + 1];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= s.length(); j++) {
                dp[i][j] = str[i] == str[j - 1] 
                    && (j - i < 3 || dp[i + 1][j - 1]);
            }
        }

        int[] dp2 = new int[s.length() + 1];
        Arrays.fill(dp2, s.length());

        for (int j = 1; j <= s.length(); j++) {
            if (dp[0][j]) {
                dp2[0] = 0;
            }
        }

        if (dp2[0] != 0) {
            return dp2[0];
        }


                

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (dp[i][j]) {
                    dp2[j] = Math.min(dp2[j], dp2[i] + 1);
                }
            }
        }

        return dp2[s.length()] - 1;
    }

    public static void main(String[] args) {
        Solution_DP test = new Solution_DP();
        int num = test.minCut("a");
        System.out.println(num);
    }
}
