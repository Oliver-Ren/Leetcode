package MergeSortedArray;

public class Solution {
	public static void merge(int A[], int m, int B[], int n) {
		int buffer[] = new int[m+n];
		int i = 0, j = 0;
		while ( i < m || j < n){
			if (j == n || i < m && A[i] < B[j]){
				buffer[i+j] = A[i];
				if(i < m) i++;
			}
			else if (i == m || j < n && A[i] >= B[j] ){
				buffer[i+j] = B[j];
				if(j < n) j++;
			}
		}
		
		for (i = 0; i < m+n; i++)
			A[i] = buffer[i];
		
		
        
    }
	
	public static void mergeReverse(int A[], int m, int B[], int n){
		int i = m-1, j = n-1;
		while(i >= 0 || j >= 0){
			if (j < 0 || i >= 0 && A[i] > B[j]  ){
				A[i+j+1] = A[i];
				i--;
			}
			else if (i < 0 || j >= 0 && A[i] <= B[j]) {
				A[i+j+1] = B[j];
				j--;
			}
		}
	}
	
	public static void main(String args[]){
		int A[] = {1,2,3,0,0,0};
		int B[] = {2,5,6};
		mergeReverse(A,3,B,3);
		for(int i = 0; i < 6; i++)
			System.out.println(A[i]);
	}

}
