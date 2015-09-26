/**
 * Idea: divide and conquer
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
        if (n == 0) return 1.0;
        if (n == 1) return x;
        boolean isNeg = false;
        if (n < 0) {
           isNeg = true;
           n = -n;
        }

        double divided = myPow(x, n / 2);
        double result = 0.0;
        result = divided * divided;
        if (n % 2 == 1) result *= x;
        return isNeg ? -result : result;
    }
}
   
        
