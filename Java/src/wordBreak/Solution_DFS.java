import java.util.*;

/** The DFS solution.
  * time complexity: O(2^n).
  * space complexity: O(n).
  * Status: Time limit Exceeded.
  */

public class Solution_DFS {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }
        return dfs(s, 0, 0, wordDict);
    }

    private boolean dfs(String s, int beginIdx, int endIdx, Set<String> wordDict) {
        if (endIdx == s.length()) {
            return wordDict.contains(s.substring(beginIdx, endIdx));
        }

        if (dfs(s, beginIdx, endIdx + 1, wordDict)) {
            return true;
        }

        if (wordDict.contains(s.substring(beginIdx, endIdx))) {
            if (dfs(s, endIdx, endIdx + 1, wordDict)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_DFS test = new Solution_DFS();
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(test.wordBreak("leeetcode", set));
    }
}

        

