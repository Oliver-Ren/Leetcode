package UniquePaths;

public class Solution {
	// This is the DFS algorithm with the cache;
	//time: O(n^2) space: O(n^2);
	public static int[][] cache = new int[100][100];
	public int uniquePaths(int m, int n) {
	    if (m < 1 || n < 1) return 0;
	    if (m == 1 || n == 1) return 1;
	    if (cache[m-1][n-1] != 0 ) return cache[m-1][n-1];
	    else
	    return cache[m-1][n-1] = uniquePaths(m-1,n) + uniquePaths(m, n-1);
	    
	}

}
