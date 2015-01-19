package RemoveElement;

public class Solution {
    public int removeElement(int[] A, int elem) {
    	if ( A == null ) return 0;
        int len = A.length;
        int i = 0;
        int j = 0;
        while ( i + j < len){
            A[i] = A[i+j];
            if ( A[i] != elem){
                i++;
            }
            else j++;
        }
        return i;
    }

}
