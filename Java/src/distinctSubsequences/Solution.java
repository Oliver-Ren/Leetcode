/**
 * Dynamic Programming Solution.
 * State: f(i, j) represents max number of distinct subsequences
 * betwenn substring of s from 0 to i and substring of t from 0 to j.
 * Function: f(i, j) = f(i - 1, j - 1) + f(i - 1, j), if s[i] == t[j]; 
 *                     f(i - 1, j), if s[i] != t[j];
 * Initialization: f(i, 0) = 1, f(0, j) = 0;
 * Answer: f(m, n);
 *
 * Time ComplexitY: O(n^2);
 * Space Complexity: O(n^2);
 * Status: Accepted, 25ms.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        // precondition: s and t are not null.
        if (s == null || t == null) throw new NullPointerException();
        
        int m = s.length();
        int n = t.length();

        int[][] f = new int[m + 1][n + 1];
        // init
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i && j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        return f[m][n];
    }
}

