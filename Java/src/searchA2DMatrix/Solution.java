import java.util.Arrays;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		// The null condition.
		if (matrix == null || matrix[0] == null) {
			return false;
		}

		/* find the appropriate row entry for the matrix.*/
		int smallRow = 0;
		int largeRow = matrix.length - 1;
		int entry = 0; //in fact the middle index of the column

		while (smallRow <= largeRow) {
			entry = (smallRow + largeRow) / 2;
			
			if (largeRow - smallRow <= 1) {
			    if (matrix[largeRow][0] > target) {
			        entry = smallRow;
			    } else {
			        entry = largeRow;
			    }
			    
			    break;
			}

			if (matrix[entry][0] < target) {
				smallRow = entry;
			} else if (matrix[entry][0] > target) {
				largeRow = entry - 1;
			} else {
				break;
			}	

		}
		
		
		int result = Arrays.binarySearch(matrix[entry], target);
		return result < 0 ? false : true;
	}

	public static void main(String[] args) {
		Solution solu = new Solution();
		int[][] testArray = new int[1][1];
		testArray[0][0] = 1;
		System.out.println(solu.searchMatrix(testArray, 2));
	}


}
	
	

		
				

			

