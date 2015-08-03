/** This is the character couting approach.
  * the time complexity is O(n);
  * the space compexity is o(radix);
  * Status: Accepted.
  */

public class Solution_Counting {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] counting = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counting[s.charAt(i)]++;
            counting[t.charAt(i)]--;
        }

        for (int i  = 0; i < 256; i++) {
            if (counting[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Counting test = new Solution_Counting();
        String str1 = "abcde";
        String str2 = "bcade";
        System.out.println(test.isAnagram(str1, str2));
    }
}
            
