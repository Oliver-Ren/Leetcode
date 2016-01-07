/**
 * The dynamic programmig solution.
 * State: f[i][j] represents the minimum edit distance of substring from 0 
 * to i in word1 and substring from 0 to j in word2.
 * Function: f[i][j] = f[i - 1][j - 1] if word1[i] == word2[j]
 *                     min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1
 *                     if word1[i] != word2[j]
 * Initialization: f[i][0] = i, f[0][j] = j.
 * Answer: f[m][n]
 *
 * Time Complexity: O(m * n);
 * Space complexity: O(m * n);
 * Status: Accepted, 13ms
 */
public class SolutionDP {
    public int minDistance(String word1, String word2) {
        // word1 and word2 are not null
        if (word1 == null || word2 == null) throw new NullPointerException();
        int m = word1.length();
        int n = word2.length();

        int[][] f = new int[m + 1][n + 1];

        // init
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1],
                                f[i - 1][j - 1])) + 1;
                }
            }
        }

        return f[m][n];

    }
}
