/** The dynamic programming solution.
  * The function is: opt(i,j) =
  * min(opt(i - 1, j - 1) + 1, currentLeftStreak,
  * currentRightStreak.);
  * time complexity: O(n ^ 2);
  * space complexity: O(n ^ 2);
  * Status: Accepted, 412ms.
  */ 

public class SolutionDP {
    private class Cell {
        private int maxSquare;
        private int leftStreak;
        private int upperStreak;

        private Cell() {
            maxSquare = 0;
            leftStreak = 0;
            upperStreak = 0;
        }
    }
            
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maximal = 0;

        Cell[][] cells = new Cell[rowLen + 1][colLen + 1];

        for (int i = 0; i <= rowLen; i++) {
            cells[i][0] = new Cell();
        }

        for (int j = 0; j <= colLen; j++) {
            cells[0][j] = new Cell();
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                cells[i + 1][j + 1] = new Cell();
                Cell curr = cells[i + 1][j + 1]; 
                if (matrix[i][j] == '1') {
                    curr.leftStreak = cells[i + 1][j].leftStreak + 1;
                    curr.upperStreak = cells[i][j + 1].upperStreak + 1;
                    curr.maxSquare = Math.min(cells[i][j].maxSquare + 1, 
							Math.min(curr.leftStreak, curr.upperStreak)); 
                }

                maximal = Math.max(maximal, curr.maxSquare);

            }
        }

        return maximal * maximal;
    }
	
	public static void main(String[] args) {
		SolutionDP test = new SolutionDP();
		char[][] matrix = {{'0','1','1'},{'1','1','1'}};
		System.out.println(test.maximalSquare(matrix));
	}
}

		
			
				
            

        
