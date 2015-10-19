import java.util.*;
/**
 * My first attempt.
 * idea: outer loop scan, inner loop grow out.
 * Time complexity: O(n^2) in the worst case.
 * Space complexity: O(1).
 * Status: Time Limit Exceeded.
 */
public class Solution {
    public String longestPalindrome(String s) {
        // precondition: s is not null.
        if (s == null) {
            return null;
        }
        char[] str = s.toCharArray();
        int maxLen = 0;
        int maxLeft = -1;
        int maxRight = -1;
        for (int i = 0; i < str.length; i++) {
            int j = i;
            int k = i;
            while (j >= 0 && k < str.length && str[j] == str[k]) {
                if (k - j + 1 > maxLen) {
                    maxLeft = j;
                    maxRight = k;
                    maxLen = k - j + 1;
                }
                j--;
                k++;
            }
        }
        
        for (int i = 0; i < str.length - 1; i++) {
            int j = i;
            int k = i + 1;
            while (j >= 0 && k < str.length && str[j] == str[k]) {
                if (k - j + 1 > maxLen) {
                    maxLeft = j;
                    maxRight = k;
                    maxLen = k - j + 1;
                }
                j--;
                k++;
            }
        }

        return String.valueOf(str, maxLeft, maxLen);
        
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.longestPalindrome("aabab"));
    }
}
