package MaximumSubarray;

public class Solution {
	/** This is the naive DP solution with O(n) time and O(n) space. */
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        int [] opt = new int[A.length];
        opt[0] = A[0];
        for (int i = 1; i < A.length; ++i) {
            opt[i] = A[i]+opt[i-1] < A[i] ? A[i] : opt[i-1] + A[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            if (opt[i] > max) {
                max = opt[i];
            }
        }
        return max;
    }
    
    /** improved DP O(n) time , O(1) spacce */
    public int maxSubArray2(int[] A) {
        if (A == null || A.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        int opt = 0;
        for (int i = 0; i < A.length; ++i) {
            opt = Math.max(A[i], opt + A[i]);
            result = Math.max(result, opt);
        }
        return result;
    }
}