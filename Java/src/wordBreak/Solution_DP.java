import java.util.*;

/** The DP solution.
  * time complexity: O(n ^ 2).
  * space complexity: O(n).
  * Status: Accepted, 268ms.
  */

public class Solution_DP {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }

        boolean[] couldBreak = new boolean[s.length() + 1 ];
        couldBreak[0] = wordDict.contains("");

        for (int i = 0; i <= s.length(); i++) {
            boolean findBreak = false;
            for (int j = i; j >= 0 && !findBreak; j--) {
                if (j == 0) {
                    findBreak = wordDict.contains(s.substring(j, i)); 
                } else {
                    findBreak = couldBreak[j] 
                        && wordDict.contains(s.substring(j, i)); 
                }
            }
            couldBreak[i] = findBreak;
        }

        return couldBreak[s.length()];
    }

    public static void main(String[] args) {
        Solution_DP test = new Solution_DP();
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(test.wordBreak("leetcode", set));
    }
}

        


        

