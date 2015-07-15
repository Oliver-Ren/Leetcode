public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int sum = 0;
        for (int i = 0; i < 31; i++) {
           sum += (n & 1);
           n >>= 1;
        }
        return sum == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        return (n & (n -1) == 0 && n > 0);
    }

    public static void main(String [] args) {
        Solution test = new Solution();
        System.out.println(test.isPowerOfTwo(Integer.MIN_VALUE));
    }
}
