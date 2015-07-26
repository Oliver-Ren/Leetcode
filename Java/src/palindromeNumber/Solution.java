/** time complexity: O(log10N).
  * space complexity: O(1).
  * Status: Accepted, 484ms;
  */ 

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int divider = 1;
        while (x / divider >= 10) {
            divider *= 10;
        }

        while (x > 0) {
            if (x / divider != x % 10) {
                return false;
            }

            x = (x % divider) / 10;
            divider /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.isPalindrome(1001));
    }
}



