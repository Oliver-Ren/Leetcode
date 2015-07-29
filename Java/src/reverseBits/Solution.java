/* This is a iterative solution.
 * time complexity is O(n);
 * Space comlexity is O(1);
 * Status: Accepted, 332ms.
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) |  n & 1;
            n >>>= 1;
        }

        return result;
    }
}
