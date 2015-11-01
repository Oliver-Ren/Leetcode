public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        char[] strS = s.toCharArray();
        char[] strT = t.toCharArray();
        Arrays.sort(strS);
        Arrays.sort(strT);
        for (int i = 0; i < strS.length; i++) {
            if (strS[i] != strT[i]) {
                return false;
            }
        }
        return true;
    }
}
