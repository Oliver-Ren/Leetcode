import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
/**
 * Solution using arrays of size 256 instead of
 * HashMap to for the better performance of ACSII code.
 * The idea is using greedy approach.
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: Accepted.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // precondition: s is not null
        if (s == null) {
            return 0;
        }

        int[] posMap = new int[256];
        Arrays.fill(posMap, -1);
        int start = 0;
        int end = 1;    // exclusive;
        int maxLen = 0;
        
        for (; end <= s.length(); end++) {
            char curr = s.charAt(end - 1);
            if (posMap[curr] >= 0) {
                start = Math.max(posMap[curr] + 1, start);
            }
            posMap[curr] = end - 1;
            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}
