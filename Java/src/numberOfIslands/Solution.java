/**
 * My solution using disjoint-set.
 * Time complexity: O((m*n)log(m*n)) 
 * Space complexity: O(m*n);
 * Status: accepted, 19ms;
 */
public class Solution {
    private int len;
    private int height;
    private static class UF {
        private int[] parent;
        private byte[] rank;
        private int count;

        public UF(int N) {
            count = N;
            parent = new int[N];
            rank = new byte[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];  // path compression;
                p = parent[p];
            }
            return p;
        }

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
        }
    }
        
    public int numIslands(char[][] grid) {
        // precondition: the grid is not null.
        if (grid == null || grid.length == 0) {
            return 0;
        }
        height = grid.length;
        len = grid[0].length;
        UF uf = new UF(height * len);
        int seaArea = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == '0') {
                    seaArea++;
                    continue;
                }
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(xyTo1D(i, j), xyTo1D(i - 1, j));
                }

                if (i < height - 1 && grid[i + 1][j] == '1') {
                    uf.union(xyTo1D(i, j), xyTo1D(i + 1, j));
                }

                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(xyTo1D(i, j), xyTo1D(i, j - 1));
                } 

                if (j < len - 1 && grid[i][j + 1] == '1') {
                    uf.union(xyTo1D(i, j), xyTo1D(i, j + 1));
                }

            }
        }

        return uf.count() - seaArea;
    }


    private int xyTo1D(int x, int y) {
        return x * len + y;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        char[][] grid = {{'1'},{'1'}};
        System.out.println(test.numIslands(grid));
    }
}
