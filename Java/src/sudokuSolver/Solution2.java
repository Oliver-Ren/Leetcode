/**
 * The DFS backtracking solution, optimized using bit-map.
 * Alternative implmentation. 
 * Time complexity: O(9 * n ^2); 
 * Space complexity: O(n^2); for the stack space.
 * Status: Accepted.
 */
public class Solution2 {
    public void solveSudoku(char[][] board) {
        // precondition: board is not null
        if (board == null) {
            throw new NullPointerException();
        }
        
        int[] rowCand = new int[9];
        int[] colCand = new int[9];
        int[] blockCand = new int[9];

        // init the the availability vector
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int pos = 1 << (board[i][j] - '1'); 
                    rowCand[i] |= pos;
                    colCand[j] |= pos;
                    blockCand[i/3*3 + j/3] |= pos;
                }
            }
        }

        dfs(board, rowCand, colCand, blockCand, 0);

    }

    private boolean dfs(char[][] board, int[] rowCand, int[] colCand, int[] blockCand, int curr) {

        int i = 0;
        int j = 0;
        int k = curr;
        for (; k < 81; k++) {
            if (board[k / 9][k % 9] == '.') {
                i = k / 9;
                j = k % 9;
                break;
            }
        }

        if (k >= 81) {
            return true;
        }

        int pos = 1;
        int unavailable = rowCand[i] | colCand[j] | blockCand[i/3*3 + j/3];
        for (char num = '1'; num <= '9'; num++, pos <<= 1) {
            if ((unavailable & pos) == 0) {
                rowCand[i] ^= pos;
                colCand[j] ^= pos;
                blockCand[i/3*3 + j/3] ^= pos;
                board[i][j] = num;
                if (dfs(board, rowCand, colCand, blockCand, i * 9 + j + 1)) {
                    return true;
                }
                board[i][j] = '.';
                rowCand[i] ^= pos;
                colCand[j] ^= pos;
                blockCand[i/3*3 + j/3] ^= pos;
            }
        }
        return false;

    }

}
