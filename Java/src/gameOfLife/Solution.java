/**
 * The basic solution.
 * Time Complexity: O(n^2).
 * Space Complexity: O(n^2).
 * Status: Accepted.
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        // precondition: board is not null.
        if (board == null) throw new NullPointerException();
        int m = board.length;
        int n = board[0].length;
        int[][] nextBoard = new int[m][n];
        int[] nbrRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] nbrCol = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nextBoard[i][j] = checkState(board, nbrRow, nbrCol, i, j);
            }
        }

        for (int i = 0; i < m; i++) 
            board[i] = nextBoard[i].clone();
    }

    private int checkState(int[][] board, int[] nbrRow, int[] nbrCol, int i, int j) {
        int liveNbrs = 0;
        for (int k = 0; k < nbrRow.length; k++) {
            int row = i + nbrRow[k];
            int col = j + nbrCol[k];
            if (row >= 0 && row < board.length
                    && col >= 0 && col < board[0].length) {
                liveNbrs += board[row][col];
            }
        }
        if (liveNbrs == 3) return 1;
        else if (liveNbrs == 2) return board[i][j];
        return 0;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] board = {{1}};
        sl.gameOfLife(board);
        for (int[] a : board) {
            for (int i : a) {
                System.out.print(i);
            }
        }
    }
}

            
        
