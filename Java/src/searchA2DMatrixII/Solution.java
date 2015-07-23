/** The matrix is a ascending matrix,
  * therefore we could make use of that
  * and do the search.
  * time complexity: O(m + n)
  * space complexity: O(1)
  * Status: Accepted, 600ms.
  */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int colPtr = 0;
        int rowPtr = matrix.length - 1;

        while (rowPtr >= 0 && colPtr < matrix[0].length) {
            if (matrix[rowPtr][colPtr] > target) {
                rowPtr--;
            } else if (matrix[rowPtr][colPtr] < target) {
                colPtr++;
            } else {
                return true;
            }
        }

        return false;
    }


}

