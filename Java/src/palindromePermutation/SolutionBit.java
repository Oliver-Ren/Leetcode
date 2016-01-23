/**
 * solution based on bit manipulation.
 * using the principle of cancellation.
 * Time complexity: O(n);
 * Space complexity: O(1);
 * Status: Accepted.
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        // precondition: s is not null
        if (s == null) {
            throw new NullPointerException();
        }
        
        char[] str = s.toCharArray();
        char cand = 0;
        int count = 0;
        if (str.length % 2 == 0) {
            for (char c : str) {
                cand ^= c;
            }
            return cand == 0;
        } else {
            for (char c : str) {
                cand ^= c;
            }
            
            for (char c : str) {
                if (cand == c) {
                    count++;
                }
            }
            return count % 2 == 1;
        }
    }
}
