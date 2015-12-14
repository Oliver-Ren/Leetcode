/**
 * Dynamic programming Solution.
 * State: f(i, j) represents the existance of interleaving of substring 
 * of s1 from 0 to i and substring of s2 from 0 to j matches the substring
 * of s3 from 0 to (i + j).
 * Function: f(i, j) = (s1[i] == s3[i + j] && f(i - 1, j)) || 
 *                     (s2[j] == s3[i + j] && f(i, j - 1))
 * Init: f(0, 0) = true,
 *       f(i, 0) = s1[i] == s3[i] && f(i - 1, 0)
 *       f(0, j) = s2[j] == s3[j] && f(0, j - 1);
 * Answer: f(m, n) where m, n are length of s1, s2 seperetely.
 *
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Status: Accepted;
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // precondition: s1, s2, s3 are not null
        if (s1 == null || s2 == null || s3 == null) {
            throw new NullPointerException();
        }


        int m = s1.length();
        int n = s2.length();
        int o = s3.length();

        if (m + n != o) return false;

        boolean[][] f = new boolean[m + 1][n + 1];

        // initialize
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            f[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1][0];
        }

        for (int j = 1; j <= n; j++) {
            f[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && f[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] = f[i][j] || f[i -1][j];
                }

                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] = f[i][j] || f[i][j - 1];
                }
            }
            
        }

        return f[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isInterleave("a","b","ab"));
    }

}
