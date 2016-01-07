package SortColors;

public class Solution {
	/** This is rather naive solution using two passes. */
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) return;
        int wCount = 0;
        int rCount = 0;
        int bCount = 0;
        for (int i = 0; i < A.length; ++i) {
            switch(A[i]) {
                case 0: rCount++; break;
                case 1: wCount++; break;
                case 2: bCount++; break;
            }
        }
        int i = 0;
        for (; rCount > 0; i++, rCount--) {
            A[i] = 0;
        }
        for (; wCount > 0; ++i, wCount--) {
            A[i] = 1;
        }
        for (; bCount > 0; ++i, bCount--) {
            A[i] = 2;
        }
        
    }
    
    /** This is the required method which uses two pointers. */
    public void sortColors2(int[] A) {
        if (A == null || A.length == 0) return;
        int lPointer = 0;
        int rPointer = A.length - 1;
        int i = 0;
        while (i <= rPointer) {
            if (A[i] == 2) swap(A, i, rPointer--);
            else if (A[i] == 0) swap(A, lPointer++, i++);
            else i++;
        }
    }
    
    private void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}