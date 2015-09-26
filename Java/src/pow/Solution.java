/**
 * Idea: using square's square
 * Time Complexity: O(log2(n));
 * Space Complexity: O(log2(n)).
 * Status: accepted.
 */
public class Solution {
    public double myPow(double x, int n) {
        // n = 0; x = 0
        // n = 1; x = x;
        // n = 2; x = x * x;
        // n = 3; x = x ^ 2 * x;
        // n = 4; x = x ^ 2 ^ 2; times = 3
        double curr = x;
        int times = 0;
        if (n == 0) {
            return 1.0;
        }

        boolean isNeg = false;
        if (n < 0) {
            n = -n;
            isNeg = true;
        }

        int n1 = n;
        while (n1 > 0) {
            times++;
            n1 >>= 1;
        }

        double[] pows = new double[times];

        for (int i = 0; i < times; i++) {
            pows[i] = curr;
            curr *= curr;
        }

        int pow = times - 1;
        System.out.println("pow : " + pow);
        double result = 1.0;
        while (n > 0) {
            System.out.println("pows  " + pow + "=" + pows[pow]);
            result *= pows[pow];
            n -= 1 << pow;
            pow = 0;
            for (int i = n; i > 1; i >>= 1) pow++; 
        }
        return isNeg ? 1 / result : result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.myPow(2.0, 1));
    }
}
