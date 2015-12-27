/**
 * The brute force solution.
 * Time complexity: O(N) in the best case, O(MN) in the worst case.
 * where M is the length of the pattern, N is the length of the text.
 * Space complexity: O(1).
 * Status: Accepted, 3ms. 
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        // precondition: haystack and needle are not null
        if (haystack == null || needle == null) throw new NullPointerException();

        int N = haystack.length();
        int M = needle.length();

        if (M > N) return -1; 
        
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == M) return i;
        }

        return -1;

    }

}
