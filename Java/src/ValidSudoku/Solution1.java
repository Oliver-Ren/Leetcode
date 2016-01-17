/**
 * Basic solution, using 3 2d arrays
 * to validate the row, column and the block seperately.
 * time complexity: O(n^2); where n is the width.
 * space complexity: O(n^2);
 * Status:
 */
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        // precondition: board is not null
        if (board == null) {
            throw new NullPointerException();
        }

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currVal = board[i][j];
                if (currVal == '.') {
                    continue;
                }
                int currNum = currVal - '1';
                int blockIdx = i / 3 * 3 + j /3;
                if (row[i][currNum] 
                        || col[j][currNum] || block[blockIdx][currNum]) {
                    return false;
                }
                row[i][currNum] = true;
                col[j][currNum] = true;
                block[blockIdx][currNum] = true;
            }
        }

        return true;
    }
}

