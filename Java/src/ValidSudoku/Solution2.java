/**
 * This soluiton saves more space. 
 * Using bit-map to represent the occupation of each number.
 * In the outer loop, the i represents ith row, column and block 
 * for the row, col and block variable separately to validate 
 * the jth element in this row (column and the block) seperately.
 *
 * Time complexity: O(n^2); where n is the width of the board.
 * Space complexity: O(1);
 * Status: Accepted.
 */
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        // precondition: board is not null
        if (board == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < 9; i++) {
            int row = 0;
            int col = 0;
            int block = 0;
            for (int j = 0; j < 9; j++) {
                int rowVal = board[i][j] - '1';
                int colVal = board[j][i] - '1';
                int blockVal = board[i/3*3 + j/3][i%3*3 + j%3] - '1';
                if (rowVal >= 0 && (row & (1 << rowVal)) != 0
                 || colVal >= 0 && (col & (1 << colVal)) != 0
                 || blockVal >= 0 && (block & (1 << blockVal)) !=0) {
                    return false;
                }
                row |= rowVal >= 0 ? 1 << rowVal : 0;
                col |= colVal >=0 ? 1 << colVal : 0;
                block |= blockVal >= 0 ? 1 << blockVal : 0;
            }
        }

        return true;
    }
}
