public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n -1);
            count++;
        }
        return count;
        
    }

    public int hammingWieght1(int n) {
        int tmp;

        tmp = n - ((n >> 1) & 033333333333)
            - ((n >> 2) & 011111111111);
        return ((tmp + (tmp >> 3) & 030707070707) % 63;
    }
}
