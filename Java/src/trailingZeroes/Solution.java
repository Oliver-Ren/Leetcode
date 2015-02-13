package trailingZeroes;

public class Solution {
    public int trailingZeroes(int n) {
        if (n > 4) {
            return n / 5 + trailingZeroes(n / 5);
        } else {
            return 0;
        }
        
    }
    
}