package SingleNumberII;

public class Solution {
	/** This is the naive version. need improvement */
    public int singleNumber(int[] A) {
        int [] bitSum = new int[32];
        for (int i = 0; i < A.length; i++) {
        	bitSum[31] += A[i] < 0 ? 1 : 0;
	        for (int j = 0; j < 31; j++) {
	            bitSum[j] += A[i] & 1;
	            A[i] >>= 1;
	        }
        }
        int singleNum = 0;
        for (int j = 30; j >= 0; j--) {
        	singleNum <<= 1;
        	singleNum += bitSum[j] % 3;
        }
        if (bitSum[31] % 3 == 1) {
        	singleNum = Integer.MIN_VALUE + singleNum;
        }
        return singleNum;
    }
    
    public int singleNumber2(int[] A) {
        int [] bitSum = new int[32];
        for (int i = 0; i < A.length; i++) {
	        for (int j = 0; j < 32; j++) {
	            bitSum[j] += A[i] >> j & 1;
	        }
        }
        int singleNum = 0;
        for (int j = 31; j >= 0; j--) {
        	singleNum |= (bitSum[j] % 3) << j;
        }
        return singleNum;
    }
}