import java.util.*;

/** The DP_Opt solution with optimizaion
  * that the candidate length should 
  * not exceed the maximum length of
  * the words in the wordDict.
  *
  * time complexity: O(n ^ 2).
  * space complexity: O(n).
  * Status: Accepted, 256ms.
  */

public class Solution_DP_Opt {
    private int maxLength(Set<String> wordDict) {
        int maxLength = 0;
        for (String s : wordDict) {
            maxLength = Math.max(maxLength, s.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }
        
        int maxLen = maxLength(wordDict);

        boolean[] couldBreak = new boolean[s.length() + 1 ];
        couldBreak[0] = wordDict.contains("");

        for (int i = 1; i <= s.length(); i++) {
            boolean findBreak = false;
            for (int j = i - 1; i - j <= maxLen 
                    &&  j >= 0 && !findBreak; j--) {
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
        Solution_DP_Opt test = new Solution_DP_Opt();
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(test.wordBreak("leetcode", set));
    }
}

        

