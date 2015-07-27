/* simpler, 500ms. */

public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return x == rev || x == rev / 10;
    }





    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.isPalindrome(21));

    }
    
}
