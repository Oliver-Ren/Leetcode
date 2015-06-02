public class Solution {
	/** This is the dynamic programming approach for the problem. 
	  * The time complexity of the solution is O(n^2). */
    public int minPathSumDynamicProgramming(int[][] grid) {      
		/* Deal with the corner case that the grid is null or empty. */
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rowNum = grid.length;
		int colNum = grid[0].length;

		/* Set up the memoization array for the optimal subproblems. */
		int opt[][] = new int[rowNum][colNum];

		/* Deal with the first element of the optimal subproblem. */
		opt[0][0] = grid[0][0];
		
		
		/* Deal with the inital case, i.e. the first row and the first column. */
		for (int i = 1; i < rowNum; i++) {
			opt[i][0] =  opt[i-1][0] + grid[i][0];
		}

		for (int j = 1; j < colNum; j++) {
			opt[0][j] = opt[0][j-1] + grid[0][j];
		}

		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				opt[i][j] = Math.min(opt[i-1][j], opt[i][j-1]) + grid[i][j];
			}
		}
		
		return opt[rowNum - 1][colNum - 1];

    }

	/** This is the DFS approach for the problem. */
	public int minPathSumDFS(int [][] grid) {
		int [][] visited = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				visited[i][j] = -1;
			}
		}
		dfs(grid, visited, 0, 0);
		return visited[0][0];

	}


	private int dfs(int [][] grid, int[][] visited, int i, int j) {
		if (visited[i][j] >= 0) {
			return visited[i][j];
		}

		/* The base case, where the point is at the bottom right
		 * of the rectangle. */
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			visited[i][j] = grid[i][j];
		}

		else if (i != grid.length - 1 && j == grid[0].length - 1) {
			visited[i][j] = dfs(grid, visited, i + 1, j) +  grid[i][j]; 
		}

		else if (i == grid.length - 1 && j != grid[0].length - 1) {
			visited[i][j] = dfs(grid, visited, i, j + 1) + grid[i][j];
		}


		else {
			visited[i][j] = Math.min(dfs(grid, visited, i + 1, j), dfs(grid, visited, i, j + 1)) + grid[i][j];
		}

		return visited[i][j];
	}

}
