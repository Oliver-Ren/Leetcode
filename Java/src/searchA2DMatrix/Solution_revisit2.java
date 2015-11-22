/**
 * One seach pass;
 */
public class Solution_revisit2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // precondition: matrix is not null
        if (matrix == null) throw new NullPointerException();
        // precondition: matrix is not empty;
        if (matrix.length == 0 || matrix[0].length == 0) throw new IllegalArgumentException();
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0;
        int hi = m * n; 

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] > target) hi = mid;
            else lo = mid + 1;
        }

        if (lo >= hi) return false;
        return matrix[lo / n][lo % n] == target;
    }
}
