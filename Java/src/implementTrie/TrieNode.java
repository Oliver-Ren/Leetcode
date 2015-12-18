class TrieNode {
    // Initialize your data structure here.
    private static final int R = 26;
    public TrieNode[] next;
    public boolean isString;
    public TrieNode() {
        next = new TrieNode[R]; 
    }
}
