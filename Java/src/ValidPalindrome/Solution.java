package ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        char [] sArray = s.replaceAll("[^A-Za-z0-9]","").toLowerCase().toCharArray();
        for (int i = 0, j = sArray.length - 1; i < j; i++, j--) {
            if (sArray[i] != sArray[j]) {
                return false;
            }
        }
        return true;
        
    }
}
