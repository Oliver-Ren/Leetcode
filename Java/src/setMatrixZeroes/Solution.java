package SetMatrixZeroes;

public class Solution {
	 public void setZeroes(int[][] matrix) {
	        if (matrix == null) return;
	        boolean firstRowHasZero = false;
	        boolean firstColumnHasZero = false;
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        for (int i = 0; i < m; i++) {
	            if (matrix[i][0] == 0) firstColumnHasZero = true;
	        }
	        
	        for (int j = 0; j < n; j++) {
	            if (matrix[0][j] == 0) firstRowHasZero = true;
	        }
	        
	        
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j] == 0) {
	                    matrix[i][0] = matrix[0][j] = 0;
	                }
	            }
	        }
	        

	        for (int i = 1; i < m; i++) {
	            for (int j = 1; j < n; j++){
	                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for (int i = 0; i < m; i++) {
	            if (firstColumnHasZero) {
	                matrix[i][0] = 0;
	            }
	        }
	        
	        for (int j = 0; j < n; j++) {
	            if (firstRowHasZero) {
	                 matrix[0][j] = 0;
	            }
	        }
	            
	            
	    }
}
