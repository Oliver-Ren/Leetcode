/**
 * 3 rounds, the first round sets the 
 * first row and first column with zeros.
 * the second round sets the matrix except
 * the first row and col.
 * the last round set the first row and colums.
 * Time complexity: O(n*m).
 * Space complexity: O(1).
 * Status: Accepted, 2ms;
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // precondition: matrix is not null
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException();
        }


        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // zeros round, check the first column and row
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // first round 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // second round, set rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set the first column and first row.
        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }

        if (firstRowZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }

    }
}
