/** time complexity: O(m * n);
  * space complexity: O(m * n);;
  * Status: Accepted, 224ms.
  */

public class Solution_DFS_Cache {
    private int[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new int[m + 1][n + 1];
        return dfs(m, n);
    }

    private int dfs(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m == 0 || n == 0) 
            return 0;
        
        return getOrUpdate(m - 1, n) + getOrUpdate(m, n - 1);
    }

    private int getOrUpdate(int m, int n) {
        if (cache[m][n] > 0) return cache[m][n];
        return cache[m][n] = dfs(m, n);
    }

    public static void main(String[] args) {
        Solution_DFS_Cache test = new Solution_DFS_Cache();
        System.out.println(test.uniquePaths(3,3));
    }
}

