package MergeSortedArray;

public class Solution {
	public static void merge(int A[], int m, int B[], int n) {
		int buffer[] = new int[m+n];
		int i = 0, j = 0;
		while (i < m && j < n){
			if (A[i] < B[j]){
				buffer[i+j] = A[i];
				if(i < m) i++;
			}
			else{
				buffer[i+j] = B[j];
				if(j < n) j++;
			}
		}
		
		for 
		
		for (i = 0; i < m+n; i++)
			A[i] = buffer[i];
		
		
        
    }
	
	public static void main(String args[]){
		int A[] = {1,3,5,7,9,0,0,0,0,0,0,0,0,0,0};
		int B[] = {2,4,6,8,10,12,14,16};
		merge(A,5,B,8);
		for(int i = 0; i < 13; i++)
			System.out.println(A[i]);
	}

}
