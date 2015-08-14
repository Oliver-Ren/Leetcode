/** A better DP solution.
  * time compleixty: O(n^2);
  * space complexity: O(n);
  * status: Accepted, 312ms.
  */

public class Solution_DP3 {
    public int minCut(String s) {
        char[] str = s.toCharArray();
        int[] minCut = new int[str.length + 1];

        for (int i = 0; i <= str.length; i++) {
            minCut[i] = i - 1;
        }

        
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; i - j >= 0 
                    && i + j < str.length && str[i - j] == str[i + j]; j++) {
                minCut[i + j + 1] 
                    = Math.min(minCut[i + j + 1], minCut[i - j] + 1);    
            }

            for (int j = 0; i - j - 1 >= 0 
                    && i + j < str.length && str[i - j - 1] == str[i + j]; j++) {
                minCut[i + j + 1] 
                    = Math.min(minCut[i + j + 1], minCut[i - j - 1] + 1);
            }
        }

        return minCut[str.length];
    }


    public static void main(String[] args) {
        Solution_DP3 test = new Solution_DP3();
        System.out.println(test.minCut("aab"));
    }
}

        
