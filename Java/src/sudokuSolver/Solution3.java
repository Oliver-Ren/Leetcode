/**
 * Simpler but slower solution.
 * Status: Accepted, 22ms.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        // precondition: board is not null
        if (board == null) {
            throw new NullPointerException();
        }
        dfs(board);
    }
    
    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (dfs(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) {
                return false;
            }
            if (board[row][i] == k) {
                return false;
            }
        }
        
        int blockI = row / 3 * 3;
        int blockJ = col / 3 * 3;
        
        for (int i = blockI; i < blockI + 3; i++) {
            for (int j = blockJ; j < blockJ + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
