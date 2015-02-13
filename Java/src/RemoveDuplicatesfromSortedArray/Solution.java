package RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null) return -1;
        if (A.length == 0) return 0;
        int i = 0;
        int j = 0;
        while ( j < A.length - 1) {
            if (A[i] != A[j+1]) {
                i++;
            }
            j++;
            A[i] = A[j];
        }
        return i + 1;
    }
}
