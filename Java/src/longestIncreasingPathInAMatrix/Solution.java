/**
 * The DFS backtracking solution with memoization.
 * Time complexity: O((m*n)^2)
 * Space complexity: O(m*n)
 * Status: Accepted. 
 */
public class Solution {
    private static final int[] rowNeighbor = {-1, 0, 0, 1};
    private static final int[] colNeighbor = {0, -1, 1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        // precondition: matrix is not null
        if (matrix == null) {
            throw new NullPointerException();
        }
        
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, cache, i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int[][] cache, int row, int col) {
        if (cache[row][col] > 0) {
            return cache[row][col];
        }
        int maxLen = 1;
        for (int i = 0; i < rowNeighbor.length; i++) {
            int newRow = row + rowNeighbor[i];
            int newCol = col + colNeighbor[i];
            if (newRow >= 0 && newRow < matrix.length 
                    && newCol >= 0 && newCol < matrix[0].length 
                    && matrix[newRow][newCol] > matrix[row][col]) {
                maxLen = Math.max(maxLen, dfs(matrix, cache, newRow, newCol) + 1);
            }
        }
        cache[row][col] = maxLen;
        return cache[row][col];
    }
}

