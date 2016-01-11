import java.util.List;
import java.util.ArrayList;
/**
 * DFS + Trie Solution.
 * Status: Accepted.
 */
public class Solution {
    private static final int R = 26;
    private static class Node {
        private String val;
        private Node[] next = new Node[R];    
    }

    private Node add(Node parent, String word, int pos) {
        if (parent == null) {
            parent = new Node();
        }

        if (pos == word.length()) {
            parent.val = word;
            return parent;
        }

        char c = word.charAt(pos);
        parent.next[c - 'a'] = add(parent.next[c - 'a'], word, pos + 1);
        return parent;
    }

    public Node createTrie(String[] words) {
        Node root = new Node();
        for (String s : words) {
            root = add(root, s, 0);
        }
        return root;
    }

    
    public List<String> findWords(char[][] board, String[] words) {
        // precondition: board is not null
        if (board == null) throw new NullPointerException();
        Node root = createTrie(words);
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(result, board, marked, root, i, j); 
            }
        }
        
        return result;
    }

    private void search(List<String> result, char[][] board, boolean[][] marked,
            Node root, int row, int col) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }


        if (marked[row][col]) {
            return;
        }

        root = root.next[board[row][col] - 'a'];
        if (root == null) {
            return;
        }

        if (root.val != null) {
            result.add(root.val);
            root.val = null;
        }

        marked[row][col] = true;
        search(result, board, marked, root, row - 1, col);
        search(result, board, marked, root, row, col - 1);
        search(result, board, marked, root, row, col + 1);
        search(result, board, marked, root, row + 1, col);
        marked[row][col] = false;
    }
}
