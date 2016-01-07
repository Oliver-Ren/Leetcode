/**
 * An optimizaed Dynamic Programming Solution.
 * State: f(i, j) represents max number of distinct subsequences
 * betwenn substring of s from 0 to i and substring of t from 0 to j.
 * Function: f(i, j) = f(i - 1, j - 1) + f(i - 1, j), if s[i] == t[j]; 
 *                     f(i - 1, j), if s[i] != t[j];
 * Initialization: f(i, 0) = 1, f(0, j) = 0;
 * Answer: f(m, n);
 *
 * Time ComplexitY: O(m * n);
 * Space Complexity: O(n);
 * Status: Accepted, 15ms.
 */
public class Solution {
    public int numDistinct(String s, String t) {
        // precondition: s and t are not null.
        if (s == null || t == null) throw new NullPointerException();
        
        int m = s.length();
        int n = t.length();

        int[] f = new int[n + 1];
        // init
        f[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = Math.min(i, n); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[j] = f[j-1] + f[j];
                }
            }
        }

        return f[n];
    }
}

