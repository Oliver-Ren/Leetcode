/**
 * The Brute-Force Approach.
 * find the longest palindrome starting with the first character,
 * and then append the mirrored remaining into at the head of the string.
 *
 * Time complexity: O(n^2).
 * Space Complexity: O(n).
 * Status: TLE;
 */
public class Solution {
    public String shortestPalindrome(String s) {
        // precondition: s is not null
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) return s;

        int hi = s.length()  - 1;
        
        while (!isPalindrome(s, 0, hi)) hi--;
        StringBuilder sb = new StringBuilder(s.substring(hi + 1)).reverse();
        sb.append(s);
        return sb.toString();

    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.shortestPalindrome("aaba"));
    }
}
