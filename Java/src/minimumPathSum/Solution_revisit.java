import java.util.Arrays;
/**
 * One dimensional dynamic programming solution.
 * Time complexity: O(n^2)
 * Space complexity: O(n);
 * Status: 
 */
public class Solution_revisit {
    public int minPathSum(int[][] grid) {
        // precondition: grid is not null
        if (grid == null) throw new NullPointerException();
        if (grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[] opt = new int[n + 1];
        // init
        for (int i = 0; i < n; i++) {
            opt[i + 1] = opt[i] + grid[0][i];
        }
        opt[0] = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                opt[j + 1] = Math.min(opt[j], opt[j + 1]) + grid[i][j];
            }
        }

        return opt[n];

    }
}
