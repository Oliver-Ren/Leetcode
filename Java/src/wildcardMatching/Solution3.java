/* This is a recursive attempt for the wild card matching. */
public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int ptrS, int ptrP) {
        if (ptrP == p.length()) {
            return ptrS == s.length();
        }

        if (p.charAt(ptrP) == '*') {
            for (; ptrP < p.length() && p.charAt(ptrP) == '*'; ptrP++);
            while (ptrS < s.length()) {
                if (isMatch(s, p, ptrS, ptrP)) {
                    return true;
                }
                ptrS++;
            }
            return isMatch(s, p, ptrS, ptrP);
        } else if (ptrS < s.length() && (s.charAt(ptrS) == p.charAt(ptrP)
                    || p.charAt(ptrP) == '?')) {
            return isMatch(s, p, ptrS + 1, ptrP + 1);
        } else {
            return false;
        }
    }
}
