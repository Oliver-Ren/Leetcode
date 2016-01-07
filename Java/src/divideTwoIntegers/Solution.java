/**
 * The solution using bit shift and
 * the thoughts of divide and conquer.
 * 
 * Time Complexity: O(logn), 
 * Space Complexity: O(1).
 * Status: Accepted.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        // when the overflow will happen:
        // divisor == 0, Integer.MIN_VALUE / -1
        if (divisor == 0 || (dividend == Integer.MIN_VALUE
                    && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0
            || dividend > 0 && divisor < 0);
        long tempDivisor = Math.abs((long)divisor);
        long tempDividend = Math.abs((long)dividend);

        int quotient = 0;
        while (tempDividend >= tempDivisor) {
            long temp = tempDivisor;
            System.out.println("temp:" + temp);
            int count = 1;
            while ((temp << 1) <= tempDividend) {
                count <<= 1;
                temp <<= 1;
            }
            tempDividend -= temp;
            quotient += count;
        }

        return isNegative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(15,3));
    }
}
