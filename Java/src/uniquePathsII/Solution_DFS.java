/** Status: Accepted, 304ms. */
public class Solution_DFS {
    private int[][] grid;
    private int[][] cache;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        grid = obstacleGrid;
        cache = new int[m + 1][n + 1];

        return dfs(m, n);
    }

    private int dfs(int m, int n) {

        if (m == 1 && n == 1) {
            return 1 -  grid[0][0];
        }

        if (m == 0 || n == 0) {
            return 0;
        }

        if (grid[m - 1][n - 1] == 1) {
            return 0;
        }

        return getOrUpdate(m - 1, n) + getOrUpdate(m, n -1);
    }

    private int getOrUpdate(int m, int n) {
        if (cache[m][n] > 0) {
            return cache[m][n];
        } else {
             cache[m][n] = dfs(m, n);
             return cache[m][n];
        }
    }

    public static void main(String[] args) {
        Solution_DFS test = new Solution_DFS();
        int [][] grid = {{0,0,1},{0,0,0},{0,1,0}};
        System.out.println(test.uniquePathsWithObstacles(grid));
    }
}
