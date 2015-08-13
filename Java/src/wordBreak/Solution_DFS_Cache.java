import java.util.*;

/** The DFS_Cache solution.
  * time complexity: O(2^n).
  * space complexity: O(n).
  * Status: time limit exceeded.
  */

public class Solution_DFS_Cache {
    private int[][] cache;
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }

        cache = new int[s.length()][s.length() + 1];
        return dfs(s, 0, s.length(), wordDict);
    }

    private boolean dfs(String s, int beginIdx, int endIdx, Set<String> wordDict) {
        if (endIdx < beginIdx) {
            return false;
        }

        if (beginIdx == s.length()) {
            return true;
        }

        if (getOrUpdate(s, beginIdx, endIdx, wordDict)) {
            if (dfs(s, endIdx, s.length(), wordDict)) {
                return true;
            }
        }

        if (dfs(s, beginIdx, endIdx - 1, wordDict)) {
            return true;
        }


        return false;
    }

    /* the cache value: 0 is not set, 1 is false, 2 is true; */
    private boolean getOrUpdate(String s, int beginIdx, int endIdx, Set<String> wordDict) {
        if (cache[beginIdx][endIdx] == 0) {
            cache[beginIdx][endIdx] = wordDict.contains(s.substring(beginIdx, endIdx)) ? 2 : 1;
        }

        return cache[beginIdx][endIdx] == 1 ? false : true;
    }

    public static void main(String[] args) {
        Solution_DFS_Cache test = new Solution_DFS_Cache();
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(test.wordBreak("leetcode", set));
    }
}

        

