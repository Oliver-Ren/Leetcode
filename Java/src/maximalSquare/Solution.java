/** Dynamic programming solution.
 * dp function: opt(i, j) = min(opt(i - 1,j), opt(i - 1, j - 1)
 * , opt(i, j - 1) + 1; where opt(i, j) stands for maximal square
 * with matrix(i,j) as the bottom-right element.
 * time complexity: O(n^2).
 * space complexity: O(n^2).
 * Status: Accepted, 348ms.
 */

public class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		int[][] dp = new int[rowLen + 1][colLen + 1];
		int maxSquare = 0;

		for (int i = 1; i <= rowLen; i++) {
			for (int j = 1; j <= colLen; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], 
							Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
					maxSquare = Math.max(maxSquare, dp[i][j]);
				}
			}
		}

		return maxSquare * maxSquare;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		char[][] matrix = {{'0','1','1'},{'1','1','1'}};
		System.out.println(test.maximalSquare(matrix));
	}
}

		
			
				
