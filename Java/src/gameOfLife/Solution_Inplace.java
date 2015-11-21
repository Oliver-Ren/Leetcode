/**
 * The inplace solution.
 * Time Complexity: O(n^2).
 * Space Complexity: O(1).
 * Status: Accepted.
 */
public class Solution_Inplace {
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
                board[i][j] = checkState(board, nbrRow, nbrCol, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == -1) board[i][j] = 1;
            }
        }

    }

    private int checkState(int[][] board, int[] nbrRow, int[] nbrCol, int i, int j) {
        int liveNbrs = 0;
        for (int k = 0; k < nbrRow.length; k++) {
            int row = i + nbrRow[k];
            int col = j + nbrCol[k];
            if (row >= 0 && row < board.length
                    && col >= 0 && col < board[0].length) {
                liveNbrs += board[row][col] > 0 ? 1 : 0;
            }
        }
        if (board[i][j] == 0 && liveNbrs == 3) return -1;
        if (board[i][j] == 1 && liveNbrs != 2 && liveNbrs != 3) return 2;
        return board[i][j];
    }

    public static void main(String[] args) {
        Solution_Inplace sl = new Solution_Inplace();
        int[][] board = {{1}};
        sl.gameOfLife(board);
        for (int[] a : board) {
            for (int i : a) {
                System.out.print(i);
            }
        }
    }
}

            
        
