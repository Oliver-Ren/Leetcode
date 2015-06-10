public class Solution {
    public int[][] generateMatrix(int n) {
		int number = n * n;
		int i = 0;
		int j = 0;
		int [][] matrix = new int[n][n];	
		short direction = 0;
		int rightEdge = n -1;
		int lowerEdge = n - 1;
		int upperEdge = 1;
		int leftEdge = 0;

		for (int k = 0; k < number; k++) {
			matrix[i][j] = k+1;

			switch(direction) {
				case 0: j++;
						break;
				case 1: i++;
						break;
				case 2: j--;
						break;
				case 3: i--;
						break;
			}

			if (direction == 0 && j == rightEdge) {
				direction = 1;
				rightEdge--;
			}

			else if (direction == 1 && i == lowerEdge) {
				direction = 2;
				lowerEdge--;
			}

			else if (direction == 2 && j == leftEdge) {
				direction = 3;
				leftEdge++;
			}

			else if (direction == 3 && i == upperEdge) {
				direction = 0;
				upperEdge++;
			}
		}
		
		return matrix;


    }
}
