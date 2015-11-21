/**
 * Accepted;
 */
public class Solution_revisit {
    public boolean searchMatrix(int[][] matrix, int target) {
        // precondition: matrix is not null
        if (matrix == null) throw new NullPointerException();
        // precondition: matrix is not empty;
        if (matrix.length == 0 || matrix[0].length == 0) throw new IllegalArgumentException();
        // round 1: find the right bucket;
        int lo = 0;
        int hi = matrix.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) lo = mid;
            else hi = mid;
        }
       
        // round 2: find the value;
        int loCol = 0;
        int hiCol = matrix[lo].length;
        while (loCol < hiCol) {
            int mid = loCol + (hiCol - loCol) / 2;
            System.out.println("" + mid + ", " + loCol + ", " + hiCol);
            if (matrix[lo][mid] == target) return true;
            else if (matrix[lo][mid] < target) loCol = mid + 1;
            else hiCol = mid;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution_revisit s = new Solution_revisit();
        int[][] matx = {{1,1}};
        System.out.println(s.searchMatrix(matx, 0));
    }
}
