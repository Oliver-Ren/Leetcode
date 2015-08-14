/** compared with the first DP solution,
  * this one combined two DPs together.
  * and the minCut is accessed from right
  * to left.
  * Time complexity: O(n^2).
  * space complexity: O(n^2),
  * Status: Accepted, 268ms.
  */

public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        boolean[][] isPalindrome = new boolean[str.length][str.length + 1];
        int[] minCut = new int[str.length + 1];
        
        for (int i = 0; i <= str.length; i++) {
            minCut[i] = str.length - i - 1;
        }

        for (int i = str.length; i >= 0; i--) {
            for (int j = i + 1; j <= str.length; j++) {
                if (str[i] == str[j - 1] && (j - i < 3
                        || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }

        return minCut[0];
    }
}


                
