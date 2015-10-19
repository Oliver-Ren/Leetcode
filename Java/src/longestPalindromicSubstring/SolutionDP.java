import java.util.*;
/**
 * using dynamic programming approach.
 * Time complexity: O(n^2) in the worst case.
 * Space complexity: O(n^2).
 * Status: Time Limit Exceeded.
 */

public class SolutionDP {
    public String longestPalindrome(String s) {
        // precondition: s is not null
        if (s == null) {
            return null;
        }

        boolean[][] cache = new boolean[s.length()][s.length()];
        int maxLeft = 0;
        int maxRight = 1;

        for (int i = 0; i < s.length(); i++) {
            cache[i][i] = true;
            for (int j = 0; j < i; j++) {
                cache[j][i] = (s.charAt(i) == s.charAt(j)
                        && (i - j < 2 || cache[j + 1][i - 1]));
                
                if (cache[j][i] && i - j + 1 > maxRight - maxLeft) {
                    maxLeft = j;
                    maxRight = i + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight);
               
    }

    public static void main(String[] args) {
        SolutionDP test = new SolutionDP();
        System.out.println(test.longestPalindrome("aabab"));
    }
}

