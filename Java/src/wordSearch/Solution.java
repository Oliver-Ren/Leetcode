/**
 * The DFS backtracking solution.
 * Time complexity: O(n * m * ((4 - 1) ^ k)) where m is the # of rows, 
 * n is the # of columns, k is the word length; 
 * Space Complexity: O(n * m) for the marked array.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        // preconditionL: board is not null.
        if (board == null) throw new NullPointerException();
        if (board.length == 0) return word.equals(""); 
        
        // m row, n columns
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, marked, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] marked, int row, int col, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (marked[row][col] || board[row][col] != word.charAt(pos)) {
            return false;
        }

        marked[row][col] = true;
        boolean result = dfs(board, word, marked, row - 1, col, pos + 1)
                      || dfs(board, word, marked, row, col - 1, pos + 1)
                      || dfs(board, word, marked, row, col + 1, pos + 1)
                      || dfs(board, word, marked, row + 1, col, pos + 1);
        marked[row][col] = false;
        return result;
    }
}
