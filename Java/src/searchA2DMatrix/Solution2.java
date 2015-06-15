public class Solution2 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix[0] == null) {
			return false;
		}

		int rowNum = matrix.length;
		int colNum = matrix[0].length;

		int left = 0;
		int right = rowNum * colNum - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int row = mid / colNum;
			int col = mid % colNum;
			
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else if (matrix[row][col] > target) {
				right = mid - 1;
			}

		}

		return false;

	}
}
