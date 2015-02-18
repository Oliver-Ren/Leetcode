package plusOne;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) return null;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + carry) % 10;
            carry = (carry == 1 && digits[i] == 0) ? 1 : 0;
        }
        if (carry == 1) {
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = 1;
            for (int i = 1; i < newdigits.length; i++) {
                newdigits[i] = digits[i-1];
            }
            return newdigits;
        }
        return digits;
    }
}