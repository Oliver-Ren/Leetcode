/**
 * The solution based on the KMP algorihtm.
 * Time complexity: O(N+M) in the worst case..
 * where M is the length of the pattern, N is the length of the text.
 * Space complexity: O(N + M).
 * Status: Accepted, 12ms. 
 */
public class SolutionKMP {
    public int strStr(String haystack, String needle) {
        // precondition: haystack and needle are not null
        if (haystack == null || needle == null) throw new NullPointerException();
        
        int M = needle.length();
        int N = haystack.length();
        int[] next = new int[M];
 
        int j = -1;
        for (int i = 0; i < M; i++) {
            if (i == 0)                                      next[i] = -1;
            else if (needle.charAt(i) != needle.charAt(j)) next[i] = j;
            else                                             next[i] = next[j];
            while (j >= 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j];
            }
            j++;
        }


        int m = 0;
        int n = 0;
        for (m = 0, n = 0; n < N && m < M; n++) {
            while (m >= 0 && needle.charAt(m) != haystack.charAt(n)) {
                m = next[m];
            }
            m++;
        }

        if (m == M) return n - m;
        return -1;
    }

    public static void main(String[] args) {
        SolutionKMP s = new SolutionKMP();
        System.out.println(s.strStr("ababa", "bab"));
    }
}



            
