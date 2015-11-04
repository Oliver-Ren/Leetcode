/**
 * Revisit the problem.
 * Time Complexity: O(n!).
 * Space Complexity: O(n).
 * Status: Accepted.
 */

public class Solution2 {
    private boolean[] columns;
    private boolean[] diag;
    private boolean[] anti_diag;
    private int[] C;

    public List<List<String>> solveNQueens(int n) {
        // precondition: n > 0.
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        columns = new boolean[n];
        diag = new boolean[n << 1];
        anit_diag = new boolean[n << 1];
        C = new int[n];

        List<List<String>> result = new ArrayList<List<String>>();
        dfs(result, n, 0);
        return result;
    }

    private void dfs(List<String[]> result, int n, int row) {
        final int N = n;
        if (row == n) {
            List<String> singleResult = new ArrayList<String>;
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (C[i] == j)  sb.append('Q');
                    else sb.append('.');
                }
                singleResult.add(sb.toString());
            }
            result.add(singleResult);
            return;
        }

        for (int j = 0; j < N; j++) {
            boolean isConflict = columns[j] || diag[row + j] || anti_diag[N + row - j];
            if (isConflict) {
                continue;
            }
            columns[j] = diag[row + j] = anti_diag[N + row - j] = true;
            C[row] = j;
            findSolution(result, N, row + 1);
            columns[j] = diag[row + j] =anti_diag[N + row - j] = false;
        }
    }
}





