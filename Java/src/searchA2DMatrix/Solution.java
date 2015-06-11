public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		// The null condition.
		if (matrix == null || matrix[0] == null) {
			return -1;
		}

		/* find the appropriate row entry for the matrix.*/
		int smallRow = 0;
		int largeRow = matrix.length;
		int entry = 0; //in fact the middle index of the column

		while (smallRow < largeRow) {
			entry = (smallRow + largeRow) / 2;

			if (matrix[entry][0] < target) {
				smallRow = entry;
			} else if (matrix[entry][0] > target) {
				largeRow = entry - 1;
			} else {
				break;
			}

			Arrays.

		}

		
				

			

    }
}
