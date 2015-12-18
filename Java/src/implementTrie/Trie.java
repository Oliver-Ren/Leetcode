public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);  
    }

    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        if (d == word.length()) {
            x.isString = true;
            return x;
        }

        int c = word.charAt(d) - 'a';
        x.next[c] = insert(x.next[c], word, d + 1);
        return x;
    }
        

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode x = search(root, word, 0); 
        if (x == null) return false;
        return x.isString;
    }

    private TrieNode search(TrieNode x, String word, int d) {
        if (x == null) return null;
        if (d == word.length()) return x;
        int c = word.charAt(d) - 'a';
        return search(x.next[c], word, d+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return search(root, prefix, 0) != null; 
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
