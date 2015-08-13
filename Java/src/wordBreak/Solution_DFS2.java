import java.util.*;

/** The DFS2 solution.
  * time complexity: O(2^n).
  * space complexity: O(n).
  * Status: Time Limit Exceeded.
  */

public class Solution_DFS2 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }
        return dfs(s, 0, s.length(), wordDict);
    }

    private boolean dfs(String s, int beginIdx, int endIdx, Set<String> wordDict) {
        if (endIdx < beginIdx) {
            return false;
        }

        if (beginIdx == s.length()) {
            return true;
        }

        if (wordDict.contains(s.substring(beginIdx, endIdx))) {
            if (dfs(s, endIdx, s.length(), wordDict)) {
                return true;
            }
        }

        if (dfs(s, beginIdx, endIdx - 1, wordDict)) {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        Solution_DFS2 test = new Solution_DFS2();
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(test.wordBreak("leetciode", set));
    }
}

        

