package NQueensII;

public class Solution {
    private boolean [] columns;
    private boolean [] main_diag;
    private boolean [] anti_diag;
    private int count = 0;
    
    public int totalNQueens(int n) {
        this.columns = new boolean[n];
        this.main_diag = new boolean[2*n];
        this.anti_diag = new boolean[2*n];
        int [] C = new int[n];
        dfs(C, 0);
        return this.count;
      
    }
    
    private void dfs(int [] C, int row) {
        final int N = C.length;
        if (N == row) {
            this.count++;
            return;
        }
        
        for (int j = 0; j < N; ++j) {
            boolean  conflict = columns[j] || main_diag[row + j] || anti_diag[row - j + N];
            if (conflict) continue;
            C[row] = j;
            columns[j] = main_diag[row + j] = anti_diag[row - j + N] = true;
            dfs(C, row + 1);
            columns[j] = main_diag[row + j] = anti_diag[row - j + N] = false;
        }
    }
}