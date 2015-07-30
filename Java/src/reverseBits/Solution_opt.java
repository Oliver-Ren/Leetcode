/* This solution uses the method
 * of divide and conquer..
 * time complexity is O(log(sizeof(int)));
 * Space comlexity is O(1);
 * Status: Not finieshed.
 */

public class Solution_opt {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = n >> 16 | n << 16;
        n = (n & 0xFF00FF00) >> 8 | (n & 0x00FF00FF) << 8;
        n = (n & 0xF0F0F0F0) >> 4 | (n & 0x0F0F0F0F) << 4;
        n = (n & 0xCCCCCCCC) >> 2 | (n & 0x33333333) << 2;
        n = (n & 0xAAAAAAAA) >> 1 | (n & 0x55555555) << 1;
        return n;

    }

    public static void main(String [] args) {
        Solution_opt test = new Solution_opt();
        System.out.println(test.reverseBits(1));
    }
}
