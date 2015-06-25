public class Solution {
	private static void exch(int [][] matrix, int row1, int col1, int row2, int col2) {
		int temp = matrix[row1][col1];
		matrix[row1][col1] = matrix[row2][col2];
		matrix[row2][col2] = temp;
	}

	/** The first algorithms runs as follows:
	 *  1. Traspose the matrix;
	 *  2. Horizonal mirroring the matrix;
	 */

	public void rotate(int [][] matrix) {
		if (matrix == null || matrix.length < 1) {
			return;
		}
		
		final int N = matrix.length;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {

				exch(matrix, i, j, j, i);
			
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N / 2; j++) {
				exch(matrix, i, j, i, N - 1 - j);
			}
		}
	}

	/** The second algorithm rotate the matrix level by level. */
	public void rotate2(int [][] matrix) {
		if (matrix == null || matrix.length < 1) {
			return;
		}
		
		final int N = matrix.length;


		for (int level = 0; level < N / 2; level++) {

			for (int i = level; i < N - 1 - level; i++) {
				int buffer = matrix[i][level]; // store the left in the temp

				matrix[i][level] = matrix[N - 1 - level][i]; // bottom -> left
				matrix[N - 1 - level][i] = matrix[N - 1 - i][N - 1 - level]; // right -> bottom
				matrix[N - 1 - i][N - 1 - level] = matrix[level][N - 1 - i]; // top -> right
				matrix[level][N - 1 - i] = buffer; // left -> top

			}
		}


}
			
