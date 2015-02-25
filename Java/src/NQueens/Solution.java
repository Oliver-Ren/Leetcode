package NQueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private boolean [] colums;
	private boolean [] main_diag;
	private boolean [] anti_diag;
	private int [] C;
	
	public List<String[]> solveNQueens(int n) {
        this.colums = new boolean[n];
        this.main_diag = new boolean[2*n];
        this.anti_diag = new boolean[2*n];
        this.C= new int[n];
        
        List<String[]> result = new ArrayList<String[]>();
        findSolution(result, n, 0);
        return result;
    }
	
	private void findSolution(List<String[]> result, int n, int row) {
		final int N = n;
		if (row == N) {
			String [] singleSolution = new String[N];
			for (int i = 0; i < N; i++) {
				StringBuilder rowOutput = new StringBuilder();
				for (int j = 0; j < N; j++) {
					if (this.C[i] == j) {
						rowOutput.append('Q');
					} else {
						rowOutput.append('.');
					}
				}
				singleSolution[i] = rowOutput.toString();
			}
			result.add(singleSolution);
		}
		
		for (int j = 0; j < N; j++) {
			boolean isConflict = colums[j] || main_diag[row + j] || anti_diag[N + row - j];
			if (isConflict) {
				continue;
			}
			colums[j] = main_diag[row + j] = anti_diag[N + row - j] = true;
			this.C[row] = j;
			findSolution(result, N, row + 1);
			colums[j] = main_diag[row + j] = anti_diag[N + row - j] = false;
		}
		
		
	}
	
}
