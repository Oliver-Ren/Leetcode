/**
 * The solution based on Trie(Prefix tree).
 * Time complexity: O(n * k), where k is the average length of word 
 * Space complexity: O(n * k * R) where R is the radix
 * Status: Accepted.
 */
public class SolutionTrie {
    private static final int R = 26;
    private static class TrieNode {
        int numOfChildren = 0;
        TrieNode[] next = new TrieNode[R];
    }
    private TrieNode root = new TrieNode();
    private int shortestLen = Integer.MAX_VALUE;

    private void add(String word) {
        TrieNode curr = root;
        shortestLen = Math.min(shortestLen, word.length());
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next[c - 'a'] == null) {
                curr.numOfChildren++;
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
    }

    private String getLongestCommonPrefix(String str) {
        TrieNode curr = root;
        int length = 0;
        while (curr.numOfChildren == 1 && length < shortestLen) {
            curr = curr.next[str.charAt(length) - 'a'];
            length++;
        }
        return str.substring(0, length);
    }
    
    public String longestCommonPrefix(String[] strs) {
        // precondition: strs is not null
        if (strs == null) {
            throw new NullPointerException();
        }

        if (strs.length == 0) {
            return "";
        }

        for (String s : strs) {
            add(s);
        }

        return getLongestCommonPrefix(strs[0]);
    }
    
}

        
