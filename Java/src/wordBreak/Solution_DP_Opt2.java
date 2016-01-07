/**
 * Time Complexity: O(n^2).
 * Space Complexity: O(n).
 * Status: Accepted, 6ms.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // precondition: s is not null
        if (s == null) throw new NullPointerException();
        int len = s.length();
        int[] minMax = getMinAndMaxLen(wordDict);
        int minLen = minMax[0];
        int maxLen = minMax[1];
        char[] str = s.toCharArray();
        boolean[] canBreak = new boolean[len + 1];
        // init
        canBreak[0] = true;
        
        for (int i = 0; i < len; i++) {
            int start = Math.max(i - maxLen + 1, 0);
            for (int j = start; j <= i - minLen + 1; j++) {
                String curr = new String(str, j, i - j + 1);
                if (canBreak[j] && wordDict.contains(curr)) {
                    canBreak[i + 1] = true;
                    break;
                }
            }
        }
        
        return canBreak[len];
        
    }
    
    private int[] getMinAndMaxLen(Set<String> wordDict) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String s : wordDict) {
            min = Math.min(s.length(), min);
            max = Math.max(s.length(), max);
        }
        
        int[] result = new int[2];
        result[0] = min;
        result[1] = max;
        return result;
    }
}
