/**
 * Observation: if m != n, LSD is zero;
 * we can apply this in recurrance.
 * 
 * Time complexity: O(1);
 * Space complexity: O(1);
 * Status: Accepted;
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // precondition: 0 <= m <= n <= Integer.MAX_VALUE;
        if (!(0 <= m && m <= n && n <= Integer.MAX_VALUE)) {
            throw new IllegalArgumentException();
        }

        int bitCount = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            bitCount++;
        }

        return n << bitCount;
    }
}


