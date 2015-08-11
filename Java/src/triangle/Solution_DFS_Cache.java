import java.util.*;

/** the cached DFS solution.
  * time complexity: O(n^2), where n 
  * is the height of the triangle.
  * space complexity: O(n).
  * Status: 292ms.
  */

public class Solution_DFS_Cache {
    private int[][] cache;
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null) return 0;
        cache = new int[triangle.size()][triangle.size()];

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache.length; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }

        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle,
            int row, int col) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        return readOrCalc(triangle, row, col); 
    }

    private int readOrCalc(List<List<Integer>> triangle, int row, int col) {
        if (cache[row][col] != Integer.MAX_VALUE) {
            return cache[row][col];
        } else {
            return cache[row][col]
                = triangle.get(row).get(col) +
                Math.min(dfs(triangle, row + 1, col)
                        , dfs(triangle, row + 1, col + 1));
        }
    }
}

